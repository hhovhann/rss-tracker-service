package com.hhovhann.rsstrackerservice.service;

import com.hhovhann.rsstrackerservice.dto.RequestFeedDto;
import com.hhovhann.rsstrackerservice.dto.ResponseFeedDto;
import com.hhovhann.rsstrackerservice.entity.RssFeed;
import com.hhovhann.rsstrackerservice.enumes.FeedCategory;

import java.time.ZonedDateTime;
import java.util.List;

public interface FeedService {
    List<ResponseFeedDto> saveAllFeeds(List<RssFeed> feedDtos);
    List<ResponseFeedDto> createFeeds(List<RequestFeedDto> feedDtos);
    List<ResponseFeedDto> getFeedsByDateRangeAndCategory(ZonedDateTime dateFrom, ZonedDateTime dateTo, FeedCategory feedCategory);
}
