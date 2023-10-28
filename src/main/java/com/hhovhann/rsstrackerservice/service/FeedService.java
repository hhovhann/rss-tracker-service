package com.hhovhann.rsstrackerservice.service;

import com.hhovhann.rsstrackerservice.dto.RequestFeedDto;
import com.hhovhann.rsstrackerservice.dto.ResponseFeedDto;
import com.hhovhann.rsstrackerservice.enumes.Category;

import java.time.ZonedDateTime;
import java.util.List;

public interface FeedService {
    List<Long> createFeeds(List<RequestFeedDto> feedDtos);
    List<ResponseFeedDto> getFeedsByDateRangeAndCategory(ZonedDateTime dateFrom, ZonedDateTime dateTo, Category category);
}
