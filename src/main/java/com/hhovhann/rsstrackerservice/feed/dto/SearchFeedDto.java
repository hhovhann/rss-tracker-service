package com.hhovhann.rsstrackerservice.feed.dto;

import jakarta.validation.constraints.NotNull;

import java.time.ZonedDateTime;
import java.util.List;

public record SearchFeedDto(@NotNull List<String> categories, @NotNull ZonedDateTime dateFrom,
                            @NotNull ZonedDateTime dateTo) {
}
