package de.bergmanninfotech.joggingtrackerapi.repo;

import de.bergmanninfotech.joggingtrackerapi.entity.Run;
import de.bergmanninfotech.joggingtrackerapi.repo.util.StreamableJpaSpecificationRepository;
import jakarta.persistence.LockModeType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Lock;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface RunRepo extends
        JpaRepository<Run, Long>,
        JpaSpecificationExecutor<Run>,
        StreamableJpaSpecificationRepository<Run> {
    @Modifying
    @Query("delete from Run r where r.user.id = :userId")
    void deleteByUserIdWithoutSelect(@Param("userId") Long userId);

    @Lock(LockModeType.PESSIMISTIC_WRITE)
    Optional<Run> findWithWriteLockingById(Long id);
}
