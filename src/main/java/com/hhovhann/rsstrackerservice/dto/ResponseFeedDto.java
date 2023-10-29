package com.hhovhann.rsstrackerservice.dto;

import java.time.ZonedDateTime;
import java.util.List;

public record ResponseFeedDto(String title, String link, String description, ZonedDateTime getPublicationDate, String author, String thumbnails, List<String> categories, String relatedIdentifiers) {

}
