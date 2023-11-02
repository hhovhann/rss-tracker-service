package com.hhovhann.rsstrackerservice.feed.exception.model;

import java.util.List;

public record ErrorResponse (String message, List<String> details ) {
}
