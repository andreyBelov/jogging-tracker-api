package de.bergmanninfotech.joggingtrackerapi;

import de.bergmanninfotech.joggingtrackerapi.entity.Run;
import de.bergmanninfotech.joggingtrackerapi.entity.User;
import de.bergmanninfotech.joggingtrackerapi.entity.base.Gender;
import de.bergmanninfotech.joggingtrackerapi.repo.RunRepo;
import de.bergmanninfotech.joggingtrackerapi.repo.UserRepo;
import de.bergmanninfotech.joggingtrackerapi.util.Calculator;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.Instant;

@Component
@Slf4j
@RequiredArgsConstructor
public class Runner implements CommandLineRunner {

    private final UserRepo userRepo;
    private final RunRepo runRepo;

    @Override
    public void run(String... args) throws Exception {
        if (userRepo.count() == 0) {
            User user = new User();
            user.setFirstName("Andrey");
            user.setLastName("Beloborodov");
            user.setBirthDate(Instant.parse("1992-06-20T21:00:00Z"));
            user.setGender(Gender.MALE);
            user = userRepo.saveAndFlush(user);

            Run run = new Run();
            run.setUser(user);
            run.setStartDateTime(Instant.parse("2023-12-09T17:00:00Z"));
            float startLat = 40.177433f;
            run.setStartLatitude(startLat);
            float startLon = 44.507597f;
            run.setStartLongitude(startLon);
            run.setFinishDateTime(Instant.parse("2023-12-09T17:03:00Z"));
            float finishLat = 40.172965f;
            run.setFinishLatitude(finishLat);
            float finishLon = 44.511341f;
            run.setFinishLongitude(finishLon);
            run.setDistance(Calculator.calculateDistanceInMeters(startLat, startLon, finishLat, finishLon));
            run.setAvgSpeed(Calculator.calculateAvgSpeedInKmPerHour(run.getDistance(), run.getStartDateTime(), run.getFinishDateTime()));
            runRepo.save(run);
        }
    }
}
