package com.hhovhann.rsstrackerservice.service;

import com.hhovhann.rsstrackerservice.dto.ResponseFeedDto;
import com.hhovhann.rsstrackerservice.entity.RssFeed;
import com.hhovhann.rsstrackerservice.mapper.FeedMapper;
import com.hhovhann.rsstrackerservice.repository.FeedRepository;
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
    public boolean isFeedExist(RssFeed feed) {
        log.debug("isFeedExist, feed: {}", feed);

        return feedRepository.exists(Example.of(feed));
    }

    @Override
    public List<ResponseFeedDto> storeFeeds(List<RssFeed> feeds) {
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
//        var feeds = feedRepository.findAllByCategoriesIsInAndPublicationDateBetween(categories, dateFrom, dateTo); TODO ENABLED AFTER CLARIFYING THE CATEGORIES PART

        return feeds.stream().map(feedMapper::toResponseDto).toList();
    }
}
