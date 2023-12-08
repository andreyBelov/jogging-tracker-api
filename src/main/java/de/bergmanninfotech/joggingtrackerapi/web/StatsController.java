package de.bergmanninfotech.joggingtrackerapi.web;

import de.bergmanninfotech.joggingtrackerapi.dto.UserStatsResponse;
import io.swagger.v3.oas.annotations.Parameter;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.Instant;

@RestController
@RequestMapping("/api")
public class StatsController {

    @GetMapping(path = "/stats", produces = MediaType.APPLICATION_JSON_VALUE)
    public UserStatsResponse getUserStats(@Parameter(example = "1") @RequestParam Long userId,
                                          @Parameter(example = "2023-12-09T09:00Z") @RequestParam(required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) Instant from,
                                          @Parameter(example = "2023-12-31T18:00Z") @RequestParam(required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) Instant to) {
        return null;
    }
}
