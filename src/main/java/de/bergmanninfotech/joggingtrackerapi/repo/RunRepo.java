package de.bergmanninfotech.joggingtrackerapi.repo;

import de.bergmanninfotech.joggingtrackerapi.entity.Run;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RunRepo extends JpaRepository<Run, Long> {
}
