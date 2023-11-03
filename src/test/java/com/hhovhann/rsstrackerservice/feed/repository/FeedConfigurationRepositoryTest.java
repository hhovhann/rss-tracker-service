package com.hhovhann.rsstrackerservice.feed.repository;

import com.hhovhann.rsstrackerservice.feed.entity.FeedConfiguration;
import com.hhovhann.rsstrackerservice.feed.entity.FeedEntity;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.testcontainers.containers.GenericContainer;
import org.testcontainers.containers.PostgreSQLContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;

import java.time.ZonedDateTime;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Testcontainers(disabledWithoutDocker = true)
@TestPropertySource(properties = "scheduler.enabled=false")
class FeedConfigurationRepositoryTest {
    @Container
    static final GenericContainer POSTGRES = new PostgreSQLContainer("postgres:14.5")
            .withDatabaseName("rss-tracker-test-db")
            .withInitScript("src/test/resources/create_feed_configuration_data.sql");

    static {
        if (!POSTGRES.isRunning()) {
            POSTGRES.start();
        }
    }

    @Autowired
    FeedConfigurationRepository feedConfigurationRepository;

    @Test
    void shouldFindAllByCategoriesInIgnoreCaseAndPublicationDateBetween() {
        List<FeedConfiguration> feedConfigurations = feedConfigurationRepository.findAllByIngestionEnableTrue();

        assertEquals(1, feedConfigurations.size());
    }

}