package de.bergmanninfotech.joggingtrackerapi.service;

import de.bergmanninfotech.joggingtrackerapi.dto.RunFinishRequest;
import de.bergmanninfotech.joggingtrackerapi.dto.RunFinishResponse;
import de.bergmanninfotech.joggingtrackerapi.dto.RunResponse;
import de.bergmanninfotech.joggingtrackerapi.dto.RunStartRequest;
import de.bergmanninfotech.joggingtrackerapi.dto.RunStartResponse;
import de.bergmanninfotech.joggingtrackerapi.dto.UserStatsResponse;
import de.bergmanninfotech.joggingtrackerapi.entity.Run;
import de.bergmanninfotech.joggingtrackerapi.entity.User;
import de.bergmanninfotech.joggingtrackerapi.exception.InvalidApiUsageException;
import de.bergmanninfotech.joggingtrackerapi.exception.RunNotFoundException;
import de.bergmanninfotech.joggingtrackerapi.exception.UserNotFoundException;
import de.bergmanninfotech.joggingtrackerapi.exception.UserStatsNotFoundException;
import de.bergmanninfotech.joggingtrackerapi.mapper.RunMapper;
import de.bergmanninfotech.joggingtrackerapi.repo.RunRepo;
import de.bergmanninfotech.joggingtrackerapi.repo.UserRepo;
import de.bergmanninfotech.joggingtrackerapi.util.Calculator;
import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
import lombok.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.Duration;
import java.time.Instant;
import java.util.Optional;
import java.util.function.BiFunction;
import java.util.function.BinaryOperator;
import java.util.stream.Stream;

import static de.bergmanninfotech.joggingtrackerapi.entity.RunSpecs.startDateTimeGreaterThanOrEqualTo;
import static de.bergmanninfotech.joggingtrackerapi.entity.RunSpecs.startDateTimeLessThan;
import static de.bergmanninfotech.joggingtrackerapi.entity.RunSpecs.userIdEquals;
import static de.bergmanninfotech.joggingtrackerapi.util.Calculator.calculateAvgSpeedInKmPerHour;
import static de.bergmanninfotech.joggingtrackerapi.util.Calculator.calculateDistanceInMeters;

@Service
@RequiredArgsConstructor
public class RunService {
    private final UserRepo userRepo;
    private final RunRepo runRepo;
    private final RunMapper runMapper;
    private final EntityManager entityManager;

    @Transactional
    public RunStartResponse startRun(RunStartRequest runStartRequest) {
        User user = userRepo.findWithReadLockingById(runStartRequest.getUserId())
                .orElseThrow(() -> new UserNotFoundException(runStartRequest.getUserId()));
        Run runSaved = runRepo.save(runMapper.map(runStartRequest, user));
        return runMapper.mapToStartResponse(runSaved);
    }

    @Transactional
    public RunFinishResponse finishRun(Long id, RunFinishRequest runFinishRequest) {
        Run run = runRepo.findWithWriteLockingById(id)
                .orElseThrow(() -> new RunNotFoundException(id));
        if (run.getFinishDateTime() != null) {
            throw new InvalidApiUsageException("The run with id = " + id + " cannot be finished again");
        }
        if (!runFinishRequest.getFinishDateTime().isAfter(run.getStartDateTime())) {
            throw new InvalidApiUsageException("Finish date time cannot be earlier than start date time");
        }
        run.setFinishDateTime(runFinishRequest.getFinishDateTime());
        run.setFinishLatitude(runFinishRequest.getFinishLatitude());
        run.setFinishLongitude(runFinishRequest.getFinishLongitude());
        run.setDistance(Optional.ofNullable(runFinishRequest.getDistance())
                .orElse(calculateDistanceInMeters(
                        run.getStartLatitude(),
                        run.getStartLongitude(),
                        run.getFinishLatitude(),
                        run.getFinishLongitude()))
        );
        run.setAvgSpeed(calculateAvgSpeedInKmPerHour(
                run.getDistance(),
                run.getStartDateTime(),
                run.getFinishDateTime())
        );
        Run updatedRun = runRepo.save(run);
        return runMapper.mapToFinishResponse(updatedRun);
    }

    private Long calculateDistance(Run run) {
        return calculateDistanceInMeters(
                run.getStartLatitude(),
                run.getStartLongitude(),
                run.getFinishLatitude(),
                run.getFinishLongitude());
    }

    @Transactional(readOnly = true)
    public Page<RunResponse> findAll(Long userId, Instant from, Instant to, Pageable pageable) {
        Specification<Run> filter = Specification.where(userIdEquals(userId))
                .and(startDateTimeGreaterThanOrEqualTo(from))
                .and(startDateTimeLessThan(to));
        return runRepo.findAll(filter, pageable)
                .map(run -> runMapper.mapToResponse(run, userId));
    }

    @Transactional(readOnly = true)
    public UserStatsResponse getUserStats(Long userId, Instant from, Instant to) {
        Specification<Run> filter = Specification.where(userIdEquals(userId))
                .and(startDateTimeGreaterThanOrEqualTo(from))
                .and(startDateTimeLessThan(to));
        try (Stream<Run> runs = runRepo.stream(filter, Run.class)) {
            UserStats userStats = runs.peek(entityManager::detach)
                    .reduce(
                            new UserStats(userId, 0L, 0L, 0L),
                            accumulator(),
                            combiner()
                    );
            if (userStats.getTime() > 0) {
                return new UserStatsResponse(
                        userStats.getUserId(),
                        userStats.getRunsCount(),
                        userStats.getDistance(),
                        calculateAvgSpeedInKmPerHour(userStats.getDistance(), userStats.getTime()));
            } else {
                throw new UserStatsNotFoundException("User stats hasn't been found for userId = " + userId);
            }
        }
    }

    private BinaryOperator<UserStats> combiner() {
        return (userStats, userStats2) -> new UserStats(
                userStats.getUserId(),
                userStats.getRunsCount() + userStats2.getRunsCount(),
                userStats.getDistance() + userStats2.getDistance(),
                userStats.getTime() + userStats2.getTime());
    }

    private BiFunction<UserStats, Run, UserStats> accumulator() {
        return (userStats, run) -> new UserStats(
                userStats.getUserId(),
                userStats.getRunsCount() + 1,
                userStats.getDistance() + run.getDistance(),
                userStats.getTime() + Duration.between(run.getStartDateTime(), run.getFinishDateTime()).toSeconds());
    }

    @Value
    static class UserStats {
        Long userId;
        Long runsCount;
        Long distance;
        Long time;
    }

}
