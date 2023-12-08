package de.bergmanninfotech.joggingtrackerapi.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import lombok.Value;

import java.time.Instant;

@Value
public class RunFinishRequest {

    @NotNull
    @Schema(example = "2023-12-09T18:00Z")
    Instant finishDateTime;

    @NotNull
    @Schema(example = "60.00")
    Float finishLatitude;

    @NotNull
    @Schema(example = "59.00")
    Float finishLongitude;

    Long distance;
}
