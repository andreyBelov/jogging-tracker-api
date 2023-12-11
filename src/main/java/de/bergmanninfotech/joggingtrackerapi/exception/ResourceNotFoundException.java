package de.bergmanninfotech.joggingtrackerapi.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;
import org.springframework.web.ErrorResponseException;

import java.net.URI;
import java.time.Instant;

public abstract class ResourceNotFoundException extends ErrorResponseException {

    public ResourceNotFoundException(Long id, String resourceName) {
        super(
                HttpStatus.NOT_FOUND,
                asProblemDetail(resourceName + " with id = " + id +" hasn't been found", resourceName),
                null
        );
    }

    private static ProblemDetail asProblemDetail(String message, String resourceName) {
        ProblemDetail problemDetail = ProblemDetail.forStatusAndDetail(HttpStatus.NOT_FOUND, message);
        problemDetail.setTitle(resourceName + " Not Found");
        problemDetail.setType(URI.create("https://api.jogging-tracker.com/errors/not-found"));
        problemDetail.setProperty("errorCategory", "Generic");
        problemDetail.setProperty("timestamp", Instant.now());
        return problemDetail;
    }

}
