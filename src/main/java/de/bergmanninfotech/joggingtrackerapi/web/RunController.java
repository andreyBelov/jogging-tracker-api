package de.bergmanninfotech.joggingtrackerapi.web;

import de.bergmanninfotech.joggingtrackerapi.dto.RunFinishRequest;
import de.bergmanninfotech.joggingtrackerapi.dto.RunFinishResponse;
import de.bergmanninfotech.joggingtrackerapi.dto.RunResponse;
import de.bergmanninfotech.joggingtrackerapi.dto.RunStartRequest;
import de.bergmanninfotech.joggingtrackerapi.dto.RunStartResponse;
import io.swagger.v3.oas.annotations.Parameter;
import org.springdoc.core.annotations.ParameterObject;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.Instant;

@RestController
@RequestMapping("/api")
public class RunController {

    @PostMapping(path = "/runs", produces = MediaType.APPLICATION_JSON_VALUE)
    public RunStartResponse startRun(@RequestBody RunStartRequest runStartRequest){
        return null;
    }

    @PostMapping(path = "/runs/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public RunFinishResponse finishRun(@Parameter(example = "1") @PathVariable Long id,
                                       @RequestBody RunFinishRequest runFinishRequest) {
        return null;
    }

    @GetMapping(path = "/runs", produces = MediaType.APPLICATION_JSON_VALUE)
    public Page<RunResponse> getRunsByUserId(@Parameter(example = "1") @RequestParam Long userId,
                                             @Parameter(example = "2023-12-09T09:00Z") @RequestParam(required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) Instant from,
                                             @Parameter(example = "2023-12-31T18:00Z") @RequestParam(required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) Instant to,
                                             @ParameterObject Pageable pageable) {
        return null;
    }
}
