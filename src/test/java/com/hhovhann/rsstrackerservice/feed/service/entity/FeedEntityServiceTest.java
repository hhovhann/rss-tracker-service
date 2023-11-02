package com.hhovhann.rsstrackerservice.feed.service.entity;

import com.hhovhann.rsstrackerservice.feed.dto.ResponseFeedDto;
import com.hhovhann.rsstrackerservice.feed.entity.FeedEntity;
import com.hhovhann.rsstrackerservice.feed.repository.FeedEntityRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;

import java.time.ZonedDateTime;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@SpringBootTest
class FeedEntityServiceTest {

    @Autowired
    FeedEntityService feedEntityService;

    @Mock
    FeedEntityRepository feedEntityRepository;

    @Test
    @DisplayName("Should Find Existing Feed")
    void shouldFindExistingFeed() {
        // given
        var feed = new FeedEntity();
        when(feedEntityRepository.exists(Example.of(feed, ExampleMatcher.matchingAll()))).thenReturn(true);
        // when
        boolean feedExist = feedEntityService.isFeedExist(feed);
        //then
        assertTrue(feedExist);
    }

    @Test
    @DisplayName("Should Not Find Existing Feed")
    void shouldNotFindExistingFeed() {
        // given
        var feed = new FeedEntity();
        when(feedEntityRepository.exists(Example.of(feed, ExampleMatcher.matchingAll()))).thenReturn(true);
        // when
        boolean feedExist = feedEntityService.isFeedExist(feed);
        //then
        assertFalse(feedExist);
    }

    @Test
    @DisplayName("Should Store all entries")
    void shouldStoreAllEntries() {
        List<FeedEntity> feedEntities = List.of(new FeedEntity(), new FeedEntity());
        when(feedEntityRepository.saveAll(feedEntities)).thenReturn(feedEntities);

        List<ResponseFeedDto> responseFeeds = feedEntityService.storeFeeds(List.of());

        assertEquals(responseFeeds.size(), 1L);
    }

    @Test
    @DisplayName("Should Search all entries")
    void shouldSearchAllEntries() {
        List<FeedEntity> feedEntities = List.of(new FeedEntity(), new FeedEntity());

        when(feedEntityRepository.findAllByCategoriesInIgnoreCaseAndPublicationDateBetween(List.of("JAVA", "C#"), ZonedDateTime.now(), ZonedDateTime.now().plusDays(7L))).thenReturn(feedEntities);

        List<ResponseFeedDto> responseFeeds = feedEntityService.searchFeedsByCategoriesAndDateRange(List.of(), ZonedDateTime.now(), ZonedDateTime.now().plusDays(7L));

        assertEquals(responseFeeds.size(), 1L);
    }

}