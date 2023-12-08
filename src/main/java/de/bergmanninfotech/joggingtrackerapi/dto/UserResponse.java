package de.bergmanninfotech.joggingtrackerapi.dto;

import de.bergmanninfotech.joggingtrackerapi.entity.base.Gender;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Value;

import java.time.Instant;

@Value
@Schema(requiredProperties = {"id", "firstName", "lastName", "birthDate", "gender"})
public class UserResponse {
    Long id;
    String firstName;
    String lastName;
    Instant birthDate;
    Gender gender;
}
