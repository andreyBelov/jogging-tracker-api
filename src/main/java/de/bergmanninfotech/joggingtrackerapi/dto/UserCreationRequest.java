package de.bergmanninfotech.joggingtrackerapi.dto;

import de.bergmanninfotech.joggingtrackerapi.entity.base.Gender;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Value;

import java.time.Instant;

@Value
public class UserCreationRequest {

    @NotEmpty
    @Schema(example = "Andrey")
    String firstName;

    @NotEmpty
    @Schema(example = "Beloborodov")
    String lastName;

    @NotNull
    @Schema(example = "1992-06-20T21:00Z")
    Instant birthDate;

    @NotNull
    Gender gender;
}
