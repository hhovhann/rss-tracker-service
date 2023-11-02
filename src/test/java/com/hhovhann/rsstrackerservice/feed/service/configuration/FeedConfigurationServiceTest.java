package com.hhovhann.rsstrackerservice.feed.service.configuration;

import com.hhovhann.rsstrackerservice.feed.entity.FeedConfiguration;
import com.hhovhann.rsstrackerservice.feed.repository.FeedConfigurationRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@SpringBootTest
class FeedConfigurationServiceTest {

    @Autowired
    FeedConfigurationService feedConfigurationService;
    @Mock
    private FeedConfigurationRepository feedConfigurationRepository;

    @Test
    @DisplayName("Should Find all enabled feeds for scaning")
    void shouldFindAllEnabledFeedsToScan(){
        /// given
        FeedConfiguration firstConfiguration =  new FeedConfiguration();
        firstConfiguration.setId(1L);
        firstConfiguration.setDomain("ttps://hypothes.is/stream.rss");
        firstConfiguration.setIngestionEnable(true);

        FeedConfiguration secondConfiguration =  new FeedConfiguration();
        secondConfiguration.setId(2L);
        secondConfiguration.setDomain("https://feeds.bbci.co.uk/news/science_and_environment/rss.xml");
        secondConfiguration.setIngestionEnable(false);

        when(feedConfigurationRepository.findAllByIngestionEnableTrue()).thenReturn(List.of(firstConfiguration, secondConfiguration));
        // when
        List<FeedConfiguration> enabledFeedConfigurations = feedConfigurationService.getEnabledFeedConfigurations();

        // then
        assertEquals(enabledFeedConfigurations.size(), 2);
    }

}