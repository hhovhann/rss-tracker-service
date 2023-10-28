package com.hhovhann.rsstrackerservice.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public record ResponseFeedDto(String title, String link, String description) {

}
