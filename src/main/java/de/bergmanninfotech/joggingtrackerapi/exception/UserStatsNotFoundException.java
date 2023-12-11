package de.bergmanninfotech.joggingtrackerapi.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;
import org.springframework.web.ErrorResponseException;

import java.net.URI;
import java.time.Instant;

public class UserStatsNotFoundException extends ErrorResponseException {

    public UserStatsNotFoundException(String message) {
        super(
                HttpStatus.NOT_FOUND,
                asProblemDetail(message),
                null
        );
    }

    private static ProblemDetail asProblemDetail(String message) {
        ProblemDetail problemDetail = ProblemDetail.forStatusAndDetail(HttpStatus.NOT_FOUND, message);
        problemDetail.setTitle("User stats hasn't been found");
        problemDetail.setType(URI.create("https://api.jogging-tracker.com/errors/user-stats-not-found"));
        problemDetail.setProperty("errorCategory", "Generic");
        problemDetail.setProperty("timestamp", Instant.now());
        return problemDetail;
    }

}
