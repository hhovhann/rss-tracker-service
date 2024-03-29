package com.hhovhann.rsstrackerservice.feed.service.entity;

import com.hhovhann.rsstrackerservice.feed.dto.ResponseFeedDto;
import com.hhovhann.rsstrackerservice.feed.entity.FeedEntity;
import com.hhovhann.rsstrackerservice.feed.mapper.FeedEntityMapper;
import com.hhovhann.rsstrackerservice.feed.repository.FeedEntityRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.stereotype.Service;

import java.time.ZonedDateTime;
import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class FeedEntityServiceImpl implements FeedEntityService {

    private final FeedEntityRepository feedEntityRepository;
    private final FeedEntityMapper feedEntityMapper;

    @Override
    public boolean isFeedExist(FeedEntity feed) {
        log.debug("isFeedExist, feed: {}", feed);

        return feedEntityRepository
                .exists(Example.of(feed,
                        ExampleMatcher
                                .matchingAll()
                                .withIgnorePaths("thumbnails", "title", "description", "author", "publicationDate", "categories", "relatedIdentifiers")));
    }

    @Override
    @Transactional
    public List<ResponseFeedDto> storeFeeds(List<FeedEntity> feeds) {
        log.debug("storeFeeds, feeds: {}", feeds);

        var rssFeeds = feedEntityRepository.saveAll(feeds);

        return rssFeeds
                .stream()
                .map(feedEntityMapper::toResponseDto)
                .toList();
    }

    @Override
    public List<ResponseFeedDto> searchFeedsByCategoriesAndDateRange(List<String> categories, ZonedDateTime dateFrom, ZonedDateTime dateTo) {
        log.debug("searchFeedsByCategoriesAndDateRange,  categories: {}, dateFrom: {}, dateTo: {}", categories, dateFrom, dateTo);

        var feeds = feedEntityRepository.findByCategoriesInAndPublicationDateBetween(categories, dateFrom, dateTo);

        return feeds.stream().map(feedEntityMapper::toResponseDto).toList();
    }
}
