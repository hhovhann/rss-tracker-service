package com.hhovhann.rsstrackerservice.feed.exception.model;

import lombok.Data;

import java.util.List;

//@Data
public record ErrorResponse (String message, List<String> details ) {
//    public ErrorResponse(String message, List<String> details) {
//        super();
//        this.message = message;
//        this.details = details;
//    }
//
//    private String message;
//    private List<String> details;
}
