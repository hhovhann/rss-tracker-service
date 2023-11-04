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

@SpringBootTest
@TestPropertySource(properties = "scheduler.enabled=false")
class FeedEntityServiceTest extends AbstractIntegrationTest {

    @Autowired
    FeedEntityService feedEntityService;

    @Autowired
    FeedEntityRepository feedEntityRepository;
    @Test
    @DisplayName("Should Find Existing Feed")
    void shouldFindExistingFeed() {
        // given
        var feed = new FeedEntity();
        feed.setAuthor("Andy Theimer");
        feed.setTitle("In today&#8217;s digital landscape, where content is abundant and attention spans are fleeting, promoting your blog posts effectively is more critical than ever. Neglecting email marketing as a means of distributing your blog content can have severe consequences. In this article, we&#8217;ll explore the dangers of overlooking email promotion in 2023, backed by data and [&#8230;]");
        feed.setLink("https://www.feedotter.com/blog/dangers-of-not-emailing-blog-posts-in-2023/?utm_source=rss&utm_medium=rss&utm_campaign=dangers-of-not-emailing-blog-posts-in-2023");
        // when
        boolean feedExist = feedEntityService.isFeedExist(feed);

        //then
        assertFalse(feedExist);
    }
    @Test
    @DisplayName("Should Not Find Existing Feed")
    void shouldNotFindExistingFeed() {
        // given
        var feed = new FeedEntity();
        feed.setAuthor("Hello World");
        feed.setTitle("Hello World Title");
        feed.setLink("Hello World Link");
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