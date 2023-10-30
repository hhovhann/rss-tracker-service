package com.hhovhann.rsstrackerservice.feed.configuration;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Getter
@Setter
@Configuration
@ConfigurationProperties(prefix = "feed")
public class FeedConfiguration {
    private String domain;
    private String resource;
}
