package de.bergmanninfotech.joggingtrackerapi.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Value;
import org.hibernate.validator.constraints.Range;

import java.time.Instant;

@Value
public class RunFinishRequest {

    @NotNull
    @Schema(example = "2023-12-09T17:03Z")
    Instant finishDateTime;

    @NotNull
    @Range(min = -90, max = 90)
    @Schema(example = "40.172965")
    Float finishLatitude;

    @NotNull
    @Range(min = -180, max = 180)
    @Schema(example = "44.511341")
    Float finishLongitude;

    @Positive
    @Schema(example = "500")
    Long distance;
}
