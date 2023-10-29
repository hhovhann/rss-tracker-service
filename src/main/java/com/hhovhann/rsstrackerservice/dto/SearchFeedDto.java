package com.hhovhann.rsstrackerservice.dto;

import com.hhovhann.rsstrackerservice.enumes.FeedCategory;
import jakarta.validation.constraints.NotNull;

import java.time.ZonedDateTime;

public record SearchFeedDto(@NotNull ZonedDateTime dateFrom, @NotNull ZonedDateTime dateTo, @NotNull FeedCategory category) {
}
