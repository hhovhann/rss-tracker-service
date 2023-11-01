package com.hhovhann.rsstrackerservice.feed.service.entity;

import com.hhovhann.rsstrackerservice.feed.dto.ResponseFeedDto;
import com.hhovhann.rsstrackerservice.feed.entity.FeedEntity;

import java.time.ZonedDateTime;
import java.util.List;

public interface FeedEntityService {
    /***
     * Checks is the feed exists in database: criteria query with all fields combination excluding collections and id
     * @param feed the current feed instance
     * @return true if the provided feed is exists, otherwise false
     */
    boolean isFeedExist(FeedEntity feed);

    /***
     * Stored all new Feed instances into database
     * @param feeds new Feed instances to storing
     * @return collection of response feed dto instances
     */
    List<ResponseFeedDto> storeFeeds(List<FeedEntity> feeds);

    /***
     * Search collection of enabled feeds by categories and date ranges
     * @param categories feed/channel enabled flag
     * @param dateFrom feed instance start date
     * @param dateTo feed instance end date
     * @return collection of response feed dto instances
     */
    List<ResponseFeedDto> searchFeedsByCategoriesAndDateRange(List<String> categories, ZonedDateTime dateFrom, ZonedDateTime dateTo);
}
