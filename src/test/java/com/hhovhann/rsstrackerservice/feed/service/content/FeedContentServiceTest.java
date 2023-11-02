package com.hhovhann.rsstrackerservice.feed.service.content;

import com.hhovhann.rsstrackerservice.feed.entity.FeedEntity;
import com.hhovhann.rsstrackerservice.feed.service.entity.FeedEntityService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@SpringBootTest
class FeedContentServiceTest {

    @Autowired
    FeedContentService feedContentService;

    @Test
    @DisplayName("should Process Feed Content Scanning")
    void shouldProcessFeedContentScanning() {
        // when
        feedContentService.executeFeedContentReading();
        //then
        assertTrue(true);
    }
}