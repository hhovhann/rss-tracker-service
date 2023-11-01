package com.hhovhann.rsstrackerservice.feed.service.configuration;

import com.hhovhann.rsstrackerservice.feed.entity.FeedConfiguration;
import com.hhovhann.rsstrackerservice.feed.repository.FeedConfigurationRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class FeedConfigurationServiceImpl implements FeedConfigurationService {
    private final FeedConfigurationRepository feedConfigurationRepository;
    @Override
    public List<FeedConfiguration> getEnabledFeedConfigurations() {
        return feedConfigurationRepository.findAllByIngestionEnableTrue();
    }
}
