package de.bergmanninfotech.joggingtrackerapi.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Value;
import org.hibernate.validator.constraints.Range;

import java.time.Instant;

@Value
public class RunStartRequest {

    @NotNull
    @Positive
    @Schema(example = "1")
    Long userId;

    @NotNull
    @Range(min = -90, max = 90)
    @Schema(example = "40.177433")
    Float startLatitude;

    @NotNull
    @Range(min = -180, max = 180)
    @Schema(example = "44.507597")
    Float startLongitude;

    @NotNull
    @Schema(example = "2023-12-09T17:00Z")
    Instant startDateTime;
}
