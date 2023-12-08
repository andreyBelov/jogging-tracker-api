package de.bergmanninfotech.joggingtrackerapi.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Value;

import java.time.Instant;

@Value
@Schema(requiredProperties = {"id", "userId", "startDateTime", "startLatitude", "startLongitude"})
public class RunStartResponse {
    Long id;
    Long userId;
    Instant startDateTime;
    Float startLatitude;
    Float startLongitude;
}
