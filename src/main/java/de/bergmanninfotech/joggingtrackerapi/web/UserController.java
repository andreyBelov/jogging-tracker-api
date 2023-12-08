package de.bergmanninfotech.joggingtrackerapi.web;

import de.bergmanninfotech.joggingtrackerapi.dto.UserCreationRequest;
import de.bergmanninfotech.joggingtrackerapi.dto.UserResponse;
import io.swagger.v3.oas.annotations.Parameter;
import org.springdoc.core.annotations.ParameterObject;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class UserController {

    @GetMapping(path = "/users", produces = MediaType.APPLICATION_JSON_VALUE)
    public Page<UserResponse> getUsers(@ParameterObject Pageable pageable) {
        return null;
    }

    @GetMapping(path = "/users/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public UserResponse getUserById(@Parameter(example = "1") @PathVariable Long id) {
        return null;
    }

    @PostMapping(path = "/users", produces = MediaType.APPLICATION_JSON_VALUE)
    public UserResponse createUser(@RequestBody UserCreationRequest userCreationRequest) {
        return null;
    }

    @PostMapping(path = "/users/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public UserResponse updateUser(@Parameter(example = "1") @PathVariable Long id, @RequestBody UserCreationRequest userUpdateRequest) {
        return null;
    }

    @DeleteMapping(path = "/users/{id}")
    public void deleteUserById(@Parameter(example = "1") @PathVariable Long id) {

    }
}
