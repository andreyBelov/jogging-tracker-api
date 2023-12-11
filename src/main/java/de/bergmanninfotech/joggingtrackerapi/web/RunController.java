package de.bergmanninfotech.joggingtrackerapi.web;

import de.bergmanninfotech.joggingtrackerapi.dto.RunFinishRequest;
import de.bergmanninfotech.joggingtrackerapi.dto.RunFinishResponse;
import de.bergmanninfotech.joggingtrackerapi.dto.RunResponse;
import de.bergmanninfotech.joggingtrackerapi.dto.RunStartRequest;
import de.bergmanninfotech.joggingtrackerapi.dto.RunStartResponse;
import de.bergmanninfotech.joggingtrackerapi.service.RunService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springdoc.core.annotations.ParameterObject;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.MediaType;
import org.springframework.http.ProblemDetail;
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
@RequiredArgsConstructor
public class RunController {
    private final RunService runService;

    @PostMapping(path = "/runs", produces = MediaType.APPLICATION_JSON_VALUE)
    @Operation(summary = "Start new run")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Run has been created successfully"),
            @ApiResponse(
                    responseCode = "400",
                    description = "Invalid request body",
                    content = @Content(
                            mediaType = "application/json",
                            schema = @Schema(implementation = ProblemDetail.class))
            ),
            @ApiResponse(
                    responseCode = "404",
                    description = "User hasn't been found",
                    content = @Content(
                            mediaType = "application/json",
                            schema = @Schema(implementation = ProblemDetail.class))
            )
    })
    public RunStartResponse startRun(@Valid @RequestBody RunStartRequest runStartRequest){
        return runService.startRun(runStartRequest);
    }

    @PostMapping(path = "/runs/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    @Operation(summary = "Finish previously started run")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Run has been updated successfully"),
            @ApiResponse(
                    responseCode = "400",
                    description = "Invalid request body",
                    content = @Content(
                            mediaType = "application/json",
                            schema = @Schema(implementation = ProblemDetail.class))
            ),
            @ApiResponse(
                    responseCode = "404",
                    description = "Run hasn't been found",
                    content = @Content(
                            mediaType = "application/json",
                            schema = @Schema(implementation = ProblemDetail.class))
            )
    })
    public RunFinishResponse finishRun(@Parameter(example = "1") @PathVariable Long id,
                                       @Valid @RequestBody RunFinishRequest runFinishRequest) {
        return runService.finishRun(id, runFinishRequest);
    }

    @GetMapping(path = "/runs", produces = MediaType.APPLICATION_JSON_VALUE)
    @Operation(summary = "Get paged run list of certain user with optional filtering by date range")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Runs have been found successfully")
    })
    public Page<RunResponse> getRunsByUserId(@Parameter(example = "1") @RequestParam Long userId,
                                             @Parameter(example = "2023-12-09T09:00Z") @RequestParam(required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) Instant from,
                                             @Parameter(example = "2023-12-31T18:00Z") @RequestParam(required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) Instant to,
                                             @ParameterObject Pageable pageable) {
        return runService.findAll(userId, from, to, pageable);
    }
}
