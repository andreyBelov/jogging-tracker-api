package de.bergmanninfotech.joggingtrackerapi.repo;

import de.bergmanninfotech.joggingtrackerapi.entity.User;
import jakarta.persistence.LockModeType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Lock;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface UserRepo extends JpaRepository<User, Long> {
    @Modifying
    @Query("delete from User u where u.id = :id")
    void deleteByIdWithoutSelect(@Param("id") Long id);

    @Lock(LockModeType.PESSIMISTIC_READ)
    Optional<User> findWithReadLockingById(Long id);

}
