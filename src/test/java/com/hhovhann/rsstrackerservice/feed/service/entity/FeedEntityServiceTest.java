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
import org.springframework.test.context.TestPropertySource;

import java.time.ZonedDateTime;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@SpringBootTest
@TestPropertySource(properties = "scheduler.enabled=false")
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

        assertEquals(responseFeeds.size(), 0);
    }

    @Test
    @DisplayName("Should Search all entries")
    void shouldSearchAllEntries() {
        ZonedDateTime now = ZonedDateTime.now();
        ZonedDateTime afterSevenDays = now.plusDays(7L);
        List<FeedEntity> feedEntities = List.of(new FeedEntity(), new FeedEntity());

        when(feedEntityRepository.findAllByCategoriesInIgnoreCaseAndPublicationDateBetween(List.of("JAVA", "C#"), now, afterSevenDays)).thenReturn(feedEntities);

        List<ResponseFeedDto> responseFeeds = feedEntityService.searchFeedsByCategoriesAndDateRange(List.of("JAVA", "C#"), now, afterSevenDays);

        assertEquals(responseFeeds.size(), 0);
    }

}