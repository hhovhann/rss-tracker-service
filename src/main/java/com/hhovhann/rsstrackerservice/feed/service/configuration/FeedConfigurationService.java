package com.hhovhann.rsstrackerservice.feed.service.configuration;

import com.hhovhann.rsstrackerservice.feed.entity.FeedConfiguration;

import java.time.ZonedDateTime;
import java.util.List;

public interface FeedConfigurationService {

    /***
     * Retrieves all enabled feeds
     * @return collection of enable feed configurations
     */
    List<FeedConfiguration> getEnabledFeedConfigurations();

}
