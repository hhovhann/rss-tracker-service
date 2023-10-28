package com.hhovhann.rsstrackerservice.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public record RequestFeedDto(String title, String link, String description) {
}
