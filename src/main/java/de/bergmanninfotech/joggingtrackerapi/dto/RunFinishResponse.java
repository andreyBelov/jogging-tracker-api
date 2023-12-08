package de.bergmanninfotech.joggingtrackerapi.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Value;

import java.time.Instant;

@Value
@Schema(
        requiredProperties = {
                "id", "userId",
                "startDateTime", "startLatitude", "startLongitude",
                "finishDateTime","finishLatitude", "finishLongitude",
                "distance", "avgSpeed"
        })
public class RunFinishResponse {
    Long id;
    Long userId;
    Instant startDateTime;
    Float startLatitude;
    Float startLongitude;
    Instant finishDateTime;
    Float finishLatitude;
    Float finishLongitude;
    Long distance;
    Float avgSpeed;
}
