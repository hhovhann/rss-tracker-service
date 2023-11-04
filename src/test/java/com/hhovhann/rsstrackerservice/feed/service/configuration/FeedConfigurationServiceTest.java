package com.hhovhann.rsstrackerservice.feed.service.configuration;

import com.hhovhann.rsstrackerservice.AbstractIntegrationTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
@TestPropertySource(properties = "scheduler.enabled=false")
class FeedConfigurationServiceTest extends AbstractIntegrationTest {

    @Autowired
    FeedConfigurationService feedConfigurationService;

    @Test
    @DisplayName("Should Find all enabled feeds for scanning")
    void shouldFindAllEnabledFeedsToScan() {
        assertEquals(1, feedConfigurationService.getEnabledFeedConfigurations().size());
    }

}