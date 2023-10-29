package com.hhovhann.rsstrackerservice.service;


import com.hhovhann.rsstrackerservice.dto.RequestFeedDto;
import com.hhovhann.rsstrackerservice.dto.ResponseFeedDto;
import com.hhovhann.rsstrackerservice.entity.RssFeed;
import com.hhovhann.rsstrackerservice.enumes.FeedCategory;
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
public class FeedServiceImpl implements FeedService {

    private final FeedRepository feedRepository;
    private final FeedMapper feedMapper;

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
    public List<ResponseFeedDto> getFeedsByDateRangeAndCategory(ZonedDateTime dateFrom, ZonedDateTime dateTo, FeedCategory feedCategory) {
        log.debug("getFeedsByDateRangeAndCategory, dateFrom: {}, dateTo: {}, feedCategory: {}", dateFrom, dateTo, feedCategory);

        var feeds = feedRepository.findAllByFeedCategoryAndPublicationDateBetween(feedCategory, dateFrom, dateTo);
        // TODO map all feeds results to dto object and back to front end
        return feeds.stream().map(feedMapper::toDTO).toList();
    }
}
