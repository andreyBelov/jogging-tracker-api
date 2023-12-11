package de.bergmanninfotech.joggingtrackerapi.exception;

public class UserNotFoundException extends ResourceNotFoundException {

    private static final String RESOURCE_NAME = "User";

    public UserNotFoundException(Long userId) {
        super(userId, RESOURCE_NAME);
    }
}