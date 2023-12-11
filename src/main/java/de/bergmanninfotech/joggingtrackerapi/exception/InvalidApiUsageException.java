package de.bergmanninfotech.joggingtrackerapi.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;
import org.springframework.web.ErrorResponseException;

import java.net.URI;
import java.time.Instant;

public class InvalidApiUsageException extends ErrorResponseException {

    public InvalidApiUsageException(String message) {
        super(
                HttpStatus.BAD_REQUEST,
                asProblemDetail(message),
                null
        );
    }

    private static ProblemDetail asProblemDetail(String message) {
        ProblemDetail problemDetail = ProblemDetail.forStatusAndDetail(HttpStatus.BAD_REQUEST, message);
        problemDetail.setTitle("Invalid API usage");
        problemDetail.setType(URI.create("https://api.jogging-tracker.com/errors/invalid-api-usage"));
        problemDetail.setProperty("errorCategory", "Generic");
        problemDetail.setProperty("timestamp", Instant.now());
        return problemDetail;
    }

}
