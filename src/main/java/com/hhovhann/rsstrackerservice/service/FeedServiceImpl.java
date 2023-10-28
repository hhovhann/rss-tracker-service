package com.hhovhann.rsstrackerservice.service;


import com.hhovhann.rsstrackerservice.dto.RequestFeedDto;
import com.hhovhann.rsstrackerservice.dto.ResponseFeedDto;
import com.hhovhann.rsstrackerservice.entity.Feed;
import com.hhovhann.rsstrackerservice.enumes.Category;
import com.hhovhann.rsstrackerservice.mapper.FeedMapper;
import com.hhovhann.rsstrackerservice.repository.FeedRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.ZonedDateTime;
import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class FeedServiceImpl implements FeedService{

    private final FeedRepository feedRepository;
    private final FeedMapper feedMapper;
    @Override
    public List<Long> createFeeds(List<RequestFeedDto> feedDtos) {
        log.debug("createFeeds, feedDtos: {}", feedDtos);
        //TODO map all dto objects to feed objects, if need with an associations and store them to the database
        var feedIds = feedDtos.stream()
                .map(feedMapper::toEntity)
                .map(Feed::getId)
                .toList();

         return feedRepository.saveAll(feedIds);
    }

    @Override
    public List<ResponseFeedDto> getFeedsByDateRangeAndCategory(ZonedDateTime dateFrom, ZonedDateTime dateTo, Category category) {
        log.debug("getFeedsByDateRangeAndCategory, dateFrom: {}, dateTo: {}, category: {}", dateFrom, dateTo, category);

        var feeds = feedRepository.findAllByCategoryAndPublicationTimeBetween(dateFrom, dateTo, category);
        // TODO map all feeds results to dto object and back to front end
        return feeds.stream().map(feedMapper::toDTO).toList();
    }
    
}
