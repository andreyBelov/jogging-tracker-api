package de.bergmanninfotech.joggingtrackerapi.exception;

public class RunNotFoundException extends ResourceNotFoundException {

    private static final String RESOURCE_NAME = "Run";

    public RunNotFoundException(Long userId) {
        super(userId, RESOURCE_NAME);
    }
}