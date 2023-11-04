package com.hhovhann.rsstrackerservice.feed.repository;

import com.hhovhann.rsstrackerservice.AbstractIntegrationTest;
import com.hhovhann.rsstrackerservice.feed.entity.FeedConfiguration;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.testcontainers.junit.jupiter.Testcontainers;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
@Testcontainers(disabledWithoutDocker = true)
@TestPropertySource(properties = "scheduler.enabled=false")
class FeedConfigurationRepositoryTest extends AbstractIntegrationTest  {


    @Autowired
    FeedConfigurationRepository feedConfigurationRepository;

    @Test
    void shouldFindAllByCategoriesInIgnoreCaseAndPublicationDateBetween() {
        List<FeedConfiguration> feedConfigurations = feedConfigurationRepository.findAllByIngestionEnableTrue();

        assertEquals(1, feedConfigurations.size());
    }

}