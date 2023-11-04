package com.hhovhann.rsstrackerservice.feed.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.io.Serial;

@ResponseStatus(HttpStatus.TOO_MANY_REQUESTS)
public class RateLimitingException  extends RuntimeException {
    @Serial
    private static final long serialVersionUID = 8878003641503082248L;

    public RateLimitingException() {
        super();
    }

    public RateLimitingException(String message, Throwable cause) {
        super(message, cause);
    }

    public RateLimitingException(String message) {
        super(message);
    }

    public RateLimitingException(Throwable cause) {
        super(cause);
    }
}
