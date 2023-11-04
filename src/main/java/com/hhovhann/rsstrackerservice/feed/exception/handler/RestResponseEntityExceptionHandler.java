package com.hhovhann.rsstrackerservice.feed.exception.handler;

import com.hhovhann.rsstrackerservice.feed.exception.FeedContentParseException;
import com.hhovhann.rsstrackerservice.feed.exception.RateLimitingException;
import com.hhovhann.rsstrackerservice.feed.exception.model.ErrorResponse;
import com.hhovhann.rsstrackerservice.feed.exception.FeedNotFoundException;
import com.hhovhann.rsstrackerservice.feed.exception.RssTrackerValidationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.List;

@ControllerAdvice
public class RestResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {
    private static final String NOT_FOUND = "NOT_FOUND";
    private static final String BAD_REQUEST = "BAD_REQUEST";
    private static final String TOO_MANY_REQUESTS = "TOO_MANY_REQUESTS";

    private ResponseEntity<Object> generateResponseEntity(RuntimeException ex, String badRequest, HttpStatus badRequest2) {
        return new ResponseEntity<>(new ErrorResponse(badRequest, List.of(ex.getLocalizedMessage())), badRequest2);
    }
    @ExceptionHandler(RateLimitingException.class)
    protected ResponseEntity<Object> handleRateLimitingException(RuntimeException ex, WebRequest request) {
        return generateResponseEntity(ex, TOO_MANY_REQUESTS, HttpStatus.TOO_MANY_REQUESTS);
    }
    @ExceptionHandler({RssTrackerValidationException.class, FeedContentParseException.class})
    protected ResponseEntity<Object> handleValidationException(RuntimeException ex, WebRequest request) {
        return generateResponseEntity(ex, BAD_REQUEST, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(value = {FeedNotFoundException.class})
    protected ResponseEntity<Object> handleEntityNotFoundException(RuntimeException ex, WebRequest request) {
        return generateResponseEntity(ex, NOT_FOUND, HttpStatus.NOT_FOUND);
    }
}
