package de.bergmanninfotech.joggingtrackerapi.web;

import de.bergmanninfotech.joggingtrackerapi.dto.UserCreationRequest;
import de.bergmanninfotech.joggingtrackerapi.dto.UserResponse;
import de.bergmanninfotech.joggingtrackerapi.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.RequiredArgsConstructor;
import org.springdoc.core.annotations.ParameterObject;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.MediaType;
import org.springframework.http.ProblemDetail;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @GetMapping(path = "/users", produces = MediaType.APPLICATION_JSON_VALUE)
    @Operation(summary = "Get paged list of users")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Users have been found successfully")
    })
    public Page<UserResponse> getUsers(@ParameterObject Pageable pageable) {
        return userService.getUsers(pageable);
    }

    @GetMapping(path = "/users/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    @Operation(summary = "Get a user by its id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "User has been found successfully"),
            @ApiResponse(
                    responseCode = "404",
                    description = "User hasn't been found",
                    content = @Content(
                            mediaType = "application/json",
                            schema = @Schema(implementation = ProblemDetail.class))
            )
    })
    public UserResponse getUserById(@Parameter(example = "1") @PathVariable @Positive Long id) {
        return userService.getById(id);
    }

    @PostMapping(path = "/users", produces = MediaType.APPLICATION_JSON_VALUE)
    @Operation(summary = "Create new user")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "User has been created successfully"),
            @ApiResponse(
                    responseCode = "400",
                    description = "Invalid request body",
                    content = @Content(
                            mediaType = "application/json",
                            schema = @Schema(implementation = ProblemDetail.class))
            )
    })
    public UserResponse createUser(@Valid @RequestBody UserCreationRequest userCreationRequest) {
        return userService.createUser(userCreationRequest);
    }

    @PostMapping(path = "/users/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    @Operation(summary = "Update user data by its id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "User has been updated successfully"),
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
    public UserResponse updateUser(@Parameter(example = "1") @PathVariable @Positive Long id, @Valid @RequestBody UserCreationRequest userUpdateRequest) {
        return userService.updateUser(id, userUpdateRequest);
    }

    @DeleteMapping(path = "/users/{id}")
    @Operation(summary = "Delete a user by its id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "User has been deleted successfully"),
    })
    public void deleteUserById(@Parameter(example = "1") @PathVariable @Positive Long id) {
        userService.deleteUserById(id);
    }
}
