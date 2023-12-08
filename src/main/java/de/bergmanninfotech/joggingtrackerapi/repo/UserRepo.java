package de.bergmanninfotech.joggingtrackerapi.repo;

import de.bergmanninfotech.joggingtrackerapi.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<User, Long> {
}
