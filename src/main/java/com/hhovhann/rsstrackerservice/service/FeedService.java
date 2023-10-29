package com.hhovhann.rsstrackerservice.service;

import com.hhovhann.rsstrackerservice.dto.RequestFeedDto;
import com.hhovhann.rsstrackerservice.dto.ResponseFeedDto;
import com.hhovhann.rsstrackerservice.entity.RssFeed;
import java.time.ZonedDateTime;
import java.util.List;

public interface FeedService {
    /***
     * Checks is the feed exists in database: criteria query with all fields combination excluding collections and id
     * @param feed the current feed instance
     * @return true if the provided feed is exists, otherwise false
     */
    boolean isFeedExist(RssFeed feed);
    List<ResponseFeedDto> saveAllFeeds(List<RssFeed> feeds);
    List<ResponseFeedDto> createFeeds(List<RequestFeedDto> feedDtos);
    List<ResponseFeedDto> getAllFeeds(Boolean isEnabled);
    List<ResponseFeedDto> getFeedsByDateRangeAndCategory(List<String> categories, ZonedDateTime dateFrom, ZonedDateTime dateTo);
}
