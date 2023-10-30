package com.hhovhann.rsstrackerservice.feed.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.io.Serial;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class FeedNotFoundException extends RuntimeException {
    @Serial
    private static final long serialVersionUID = 2331309012439924743L;

    public FeedNotFoundException() {
        super();
    }

    public FeedNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public FeedNotFoundException(String message) {
        super(message);
    }

    public FeedNotFoundException(Throwable cause) {
        super(cause);
    }
}
