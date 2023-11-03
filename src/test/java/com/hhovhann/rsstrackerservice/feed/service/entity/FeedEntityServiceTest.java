package com.hhovhann.rsstrackerservice.feed.service.entity;

import com.hhovhann.rsstrackerservice.AbstractIntegrationTest;
import com.hhovhann.rsstrackerservice.feed.dto.ResponseFeedDto;
import com.hhovhann.rsstrackerservice.feed.entity.FeedEntity;
import com.hhovhann.rsstrackerservice.feed.repository.FeedEntityRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;

import java.time.ZonedDateTime;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
@TestPropertySource(properties = "scheduler.enabled=false")
class FeedEntityServiceTest extends AbstractIntegrationTest {

    @Autowired
    FeedEntityService feedEntityService;

    @Autowired
    FeedEntityRepository feedEntityRepository;

    @Test
    @DisplayName("Should Not Find Existing Feed")
    void shouldNotFindExistingFeed() {
        // given
        var feed = new FeedEntity();
        // when
        boolean feedExist = feedEntityService.isFeedExist(feed);
        //then
        assertFalse(feedExist);
    }

    @Test
    @DisplayName("Should Store all entries")
    void shouldStoreAllEntries() {
        List<ResponseFeedDto> responseFeeds = feedEntityService.storeFeeds(List.of());

        assertEquals(responseFeeds.size(), 0);
    }

    @Test
    @DisplayName("Should Search all entries")
    void shouldSearchAllEntries() {
        ZonedDateTime now = ZonedDateTime.now();
        ZonedDateTime afterSevenDays = now.plusDays(7L);

        List<ResponseFeedDto> responseFeeds = feedEntityService.searchFeedsByCategoriesAndDateRange(List.of("JAVA", "C#"), now, afterSevenDays);

        assertEquals(responseFeeds.size(), 0);
    }

}