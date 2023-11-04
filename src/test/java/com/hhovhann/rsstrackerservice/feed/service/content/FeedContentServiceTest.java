package com.hhovhann.rsstrackerservice.feed.service.content;

import com.hhovhann.rsstrackerservice.AbstractIntegrationTest;
import com.hhovhann.rsstrackerservice.feed.entity.FeedConfiguration;
import com.hhovhann.rsstrackerservice.feed.repository.FeedConfigurationRepository;
import com.hhovhann.rsstrackerservice.feed.repository.FeedEntityRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class FeedContentServiceTest extends AbstractIntegrationTest {

    @Autowired
    FeedContentService feedContentService;
    @Autowired
    FeedEntityRepository feedEntityRepository;
    @Autowired
    FeedConfigurationRepository feedConfigurationRepository;

    @BeforeEach
    void  setUp(){
        // Clean all feed entities and configurations
        feedEntityRepository.deleteAll();
        feedConfigurationRepository.deleteAll();
    }
    @Test
    @DisplayName("Should Process Feed Content Scanning And Store new Entity")
    void shouldProcessFeedContentScanning() {
        // Add new feed configuration and trigger feed
        var newFeedConfiguration = new FeedConfiguration();
        newFeedConfiguration.setIngestionEnable(true);
        newFeedConfiguration.setDomain("https://www.feedotter.com/blog/category/Marketo/feed/");
        feedConfigurationRepository.save(newFeedConfiguration);
        // when
        feedContentService.executeFeedContentReading();
        //then
        assertEquals(1, feedConfigurationRepository.findAllByIngestionEnableTrue().size());
    }
}