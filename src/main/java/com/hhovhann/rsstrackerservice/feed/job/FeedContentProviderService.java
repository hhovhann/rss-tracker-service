package com.hhovhann.rsstrackerservice.feed.job;

import com.hhovhann.rsstrackerservice.feed.dto.ResponseFeedDto;
import com.hhovhann.rsstrackerservice.feed.entity.FeedConfiguration;
import com.hhovhann.rsstrackerservice.feed.entity.FeedEntity;
import com.hhovhann.rsstrackerservice.feed.exception.FeedContentParseException;
import com.hhovhann.rsstrackerservice.feed.mapper.FeedEntityMapper;
import com.hhovhann.rsstrackerservice.feed.service.configuration.FeedConfigurationService;
import com.hhovhann.rsstrackerservice.feed.service.entity.FeedEntityService;
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
import org.xml.sax.InputSource;

import java.io.FileInputStream;
import java.io.InputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

@Slf4j
@Service
@EnableScheduling
@RequiredArgsConstructor
@ConditionalOnProperty(name = "scheduler.enabled", matchIfMissing = true)
public class FeedContentProviderService {

    private final FeedEntityService feedEntityService;
    private final FeedConfigurationService feedConfigurationService;
    private final FeedEntityMapper feedEntityMapper;

    @Scheduled(fixedDelay = 600000)
    public void executeFeedContentReading() {
        log.debug("executeFeedContentReading");

        // Scan Feed configuration table and get rss.xml url which are enabled
        List<FeedConfiguration> feeds = feedConfigurationService.getEnabledFeedConfigurations();

        // For each enabled feed transform item/entry data and to feed entity object and store to database
        feeds.forEach(currentFeedConfiguration -> {
            try {
                try (XmlReader reader = new XmlReader(new URL(currentFeedConfiguration.getDomain()))) {
                    SyndFeed feed = new SyndFeedInput().build(reader);
                    var feedToStore = new ArrayList<FeedEntity>();
                    for (SyndEntry entry : feed.getEntries()) {
                        log.debug("Mapping current SyndEntry to FeedEntity:{}", entry);

                        FeedEntity feedEntity = feedEntityMapper.toEntity(entry);
                        if (!feedEntityService.isFeedExist(feedEntity)) {
                            feedToStore.add(feedEntity);
                        }
                    }
                    List<ResponseFeedDto> storedFeeds = feedEntityService.storeFeeds(feedToStore);
                    log.debug("Stored {} Feed(s) to local database", storedFeeds.size());
                }
            } catch (Exception e) {
                throw new FeedContentParseException("Something went wrong.");
            }
        });
    }
}
