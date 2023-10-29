package com.hhovhann.rsstrackerservice.service;


import com.hhovhann.rsstrackerservice.dto.RequestFeedDto;
import com.hhovhann.rsstrackerservice.dto.ResponseFeedDto;
import com.hhovhann.rsstrackerservice.entity.RssFeed;
import com.hhovhann.rsstrackerservice.mapper.FeedMapper;
import com.hhovhann.rsstrackerservice.repository.FeedRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import java.time.ZonedDateTime;
import java.util.Collections;
import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class FeedServiceImpl implements FeedService {

    private final FeedRepository feedRepository;
    private final FeedMapper feedMapper;

    @Override
    public boolean isFeedExist(RssFeed feed) {
        return feedRepository.exists(Example.of(feed));
    }

    @Override
    public List<ResponseFeedDto> saveAllFeeds(List<RssFeed> feeds) {

        var stored = feedRepository.saveAll(feeds);

        return stored.stream().map(feedMapper::toDTO).toList();
    }

    @Override
    public List<ResponseFeedDto> createFeeds(List<RequestFeedDto> feedDtos) {
        log.debug("createFeeds, feedDtos: {}", feedDtos);
        //TODO map all dto objects to feed objects, if need with an associations and store them to the database
        var feeds = feedDtos.stream()
                .map(feedMapper::toEntity)
                .toList();

        var stored = feedRepository.saveAll(feeds);

        return stored.stream().map(feedMapper::toDTO).toList();
    }

    @Override
    public List<ResponseFeedDto> getAllFeeds(Boolean isEnabled) {
        log.debug("getAllFeeds, isEnabled: {}", isEnabled);

        var feeds = feedRepository.findAllByIsEnabledOrderByCategoriesAscPublicationDateAsc(true);
        // TODO map all feeds results to dto object and back to front end
        return feeds.stream().map(feedMapper::toDTO).toList();
    }

    @Override
    public List<ResponseFeedDto> getFeedsByDateRangeAndCategory(List<String> categories, ZonedDateTime dateFrom, ZonedDateTime dateTo) {
        log.debug("getFeedsByDateRangeAndCategory, dateFrom: {}, dateTo: {}, categories: {}", dateFrom, dateTo, categories);

        var feeds = feedRepository.findAllByPublicationDateBetween(dateFrom, dateTo);
        var feeds1 = feedRepository.findAllByCategoriesIsInAndPublicationDateBetween(categories, dateFrom, dateTo);
        // TODO map all feeds results to dto object and back to front end
        return feeds.stream().map(feedMapper::toDTO).toList();
    }
}
