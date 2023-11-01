package com.hhovhann.rsstrackerservice.feed.job;

import com.hhovhann.rsstrackerservice.feed.dto.ResponseFeedDto;
import com.hhovhann.rsstrackerservice.feed.entity.FeedConfiguration;
import com.hhovhann.rsstrackerservice.feed.entity.FeedEntity;
import com.hhovhann.rsstrackerservice.feed.exception.FeedContentParseException;
import com.hhovhann.rsstrackerservice.feed.mapper.FeedMapper;
import com.hhovhann.rsstrackerservice.feed.service.FeedConfigurationService;
import com.hhovhann.rsstrackerservice.feed.service.FeedService;
import com.rometools.rome.feed.synd.SyndEntry;
import com.rometools.rome.feed.synd.SyndFeed;
import com.rometools.rome.io.SyndFeedInput;
import com.rometools.rome.io.XmlReader;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;

@Slf4j
@Service
@EnableScheduling
@RequiredArgsConstructor
@ConditionalOnProperty(name = "scheduler.enabled", matchIfMissing = true)
public class FeedContentProviderService {

    private final FeedService feedService;
    private final FeedConfigurationService feedConfigurationService;
    private final FeedMapper feedMapper;

    @Scheduled(fixedDelay = 600000)
    public void executeFeedContentReading() {
        log.debug("executeFeedContentReading");

        // Step 1: Scan Feed configuration table and get rss.xml url which are enabled
        List<FeedConfiguration> feeds = feedConfigurationService.getEnabledFeedConfigurations();

        // Step 2: For each Feed enabled domain parse the entity/item data and store to FeedEntity table the update
        feeds.forEach(currentFeedConfiguration -> {
            try {
                try (XmlReader reader = new XmlReader(new URL(currentFeedConfiguration.getDomain()))) {
                    SyndFeed feed = new SyndFeedInput().build(reader);
                    var feedToStore = new ArrayList<FeedEntity>();
                    for (SyndEntry entry : feed.getEntries()) {
                        log.debug("Mapping current SyndEntry to FeedEntity:{}", entry);

                        FeedEntity feedEntity = feedMapper.toEntity(entry);
                        if (!feedService.isFeedExist(feedEntity)) {
                            feedToStore.add(feedEntity);
                        }
                    }
                    List<ResponseFeedDto> storedFeeds = feedService.storeFeeds(feedToStore);
                    log.debug("Stored {} Feed(s) to local database", storedFeeds.size());
                }
            } catch (Exception e) {
                throw new FeedContentParseException("Something went wrong");
            }
        });
    }
}
