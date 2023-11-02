package com.hhovhann.rsstrackerservice.feed.repository;

import com.hhovhann.rsstrackerservice.feed.entity.FeedConfiguration;
import com.hhovhann.rsstrackerservice.feed.entity.FeedEntity;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;

import java.time.ZonedDateTime;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@TestPropertySource(properties = "scheduler.enabled=false")
class FeedConfigurationRepositoryTest {
    @Autowired
    FeedConfigurationRepository feedConfigurationRepository;

    @Test
    void shouldFindAllByCategoriesInIgnoreCaseAndPublicationDateBetween() {
        List<FeedConfiguration> feedConfigurations = feedConfigurationRepository.findAllByIngestionEnableTrue();

        assertEquals(1, feedConfigurations.size());
    }

}