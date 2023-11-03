package com.hhovhann.rsstrackerservice.feed.service.configuration;

import com.hhovhann.rsstrackerservice.AbstractIntegrationTest;
import com.hhovhann.rsstrackerservice.feed.entity.FeedConfiguration;
import com.hhovhann.rsstrackerservice.feed.repository.FeedConfigurationRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
@TestPropertySource(properties = "scheduler.enabled=false")
class FeedConfigurationServiceTest extends AbstractIntegrationTest {

    @Autowired
    FeedConfigurationService feedConfigurationService;

    @Autowired
    FeedConfigurationRepository feedConfigurationRepository;

    @Test
    @DisplayName("Should Find all enabled feeds for scaning")
    void shouldFindAllEnabledFeedsToScan() {
        /// given
        FeedConfiguration firstConfiguration = new FeedConfiguration();
        firstConfiguration.setDomain("https://hypothes.is/stream.rss");
        firstConfiguration.setIngestionEnable(true);
        feedConfigurationRepository.save(firstConfiguration);

        FeedConfiguration secondConfiguration = new FeedConfiguration();
        secondConfiguration.setDomain("https://feeds.bbci.co.uk/news/science_and_environment/rss.xml");
        secondConfiguration.setIngestionEnable(false);
        feedConfigurationRepository.save(secondConfiguration);

        // when
        List<FeedConfiguration> enabledFeedConfigurations = feedConfigurationService.getEnabledFeedConfigurations();

        // then
        assertEquals(enabledFeedConfigurations.size(), 1);
    }

}