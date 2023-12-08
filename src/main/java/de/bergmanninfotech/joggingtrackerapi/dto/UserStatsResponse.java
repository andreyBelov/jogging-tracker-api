package de.bergmanninfotech.joggingtrackerapi.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Value;

@Value
@Schema(requiredProperties = { "userId", "runsCount", "distance", "avgSpeed" })
public class UserStatsResponse {
    Long userId;
    Long runsCount;
    Long distance;
    Float avgSpeed;
}
