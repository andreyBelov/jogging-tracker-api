package de.bergmanninfotech.joggingtrackerapi.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import lombok.Value;

import java.time.Instant;

@Value
public class RunStartRequest {

    @NotNull
    @Schema(example = "1")
    Long userId;

    @NotNull
    @Schema(example = "59.59")
    Float startLatitude;

    @NotNull
    @Schema(example = "58.58")
    Float startLongitude;

    @NotNull
    @Schema(example = "2023-12-09T17:00Z")
    Instant startDateTime;
}
