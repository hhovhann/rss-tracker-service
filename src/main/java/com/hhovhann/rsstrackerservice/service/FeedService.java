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

    /***
     * Stored all new Feed instances into database
     * @param feeds new Feed instances to storing
     * @return collection of response feed dto instances
     */
    List<ResponseFeedDto> saveAllFeeds(List<RssFeed> feeds);

    /***
     * Creates collection of feeds by provided dto request data
     * @param feedDtos collection of provided dto request data
     * @return collection of response feed dto instances
     */
    List<ResponseFeedDto> createFeeds(List<RequestFeedDto> feedDtos);

    /***
     * Retrieves collection of enabled feed response dto instances
     * @param isEnabled feed/channel enabled flag
     * @return collection of response feed dto instances
     */
    List<ResponseFeedDto> getAllFeeds(Boolean isEnabled);
    /***
     * Search collection of enabled feeds by categories and date ranges
     * @param categories feed/channel enabled flag
     * @param dateFrom feed instance start date
     * @param dateTo feed instance end date
     * @return collection of response feed dto instances
     */
    List<ResponseFeedDto> getFeedsByCategoriesAndDateRange(List<String> categories, ZonedDateTime dateFrom, ZonedDateTime dateTo);
}
