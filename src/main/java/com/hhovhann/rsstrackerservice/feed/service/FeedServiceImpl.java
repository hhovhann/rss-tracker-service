package com.hhovhann.rsstrackerservice.feed.service;

import com.hhovhann.rsstrackerservice.feed.dto.ResponseFeedDto;
import com.hhovhann.rsstrackerservice.feed.entity.FeedEntity;
import com.hhovhann.rsstrackerservice.feed.mapper.FeedMapper;
import com.hhovhann.rsstrackerservice.feed.repository.FeedRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Example;
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
    public boolean isFeedExist(FeedEntity feed) {
        log.debug("isFeedExist, feed: {}", feed);

        return feedRepository.exists(Example.of(feed));
    }

    @Override
    public List<ResponseFeedDto> storeFeeds(List<FeedEntity> feeds) {
        log.debug("storeFeeds, feeds: {}", feeds);

        var rssFeeds = feedRepository.saveAll(feeds);

        return rssFeeds
                .stream()
                .map(feedMapper::toResponseDto)
                .toList();
    }

    @Override
    public List<ResponseFeedDto> searchFeedsByCategoriesAndDateRange(List<String> categories, ZonedDateTime dateFrom, ZonedDateTime dateTo) {
        log.debug("searchFeedsByCategoriesAndDateRange,  categories: {}, dateFrom: {}, dateTo: {}", categories, dateFrom, dateTo);

        var feeds = feedRepository.findAllByPublicationDateBetween(dateFrom, dateTo); // TODO now only filtering by feed date ranges
//        var feeds = feedRepository.findAllByCategoriesContainingIgnoreCaseAndPublicationDateBetween(categories.get(0), dateFrom, dateTo);

        return feeds.stream().map(feedMapper::toResponseDto).toList();
    }
}
