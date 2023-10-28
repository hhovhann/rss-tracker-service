package com.hhovhann.rsstrackerservice.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.io.Serial;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class RssTrackerValidationException extends RuntimeException {
    @Serial
    private static final long serialVersionUID = -1507213432732877735L;

    public RssTrackerValidationException() {
        super();
    }

    public RssTrackerValidationException(String message, Throwable cause) {
        super(message, cause);
    }

    public RssTrackerValidationException(String message) {
        super(message);
    }

    public RssTrackerValidationException(Throwable cause) {
        super(cause);
    }
}
