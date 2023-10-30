package com.hhovhann.rsstrackerservice.feed.job;

import com.hhovhann.rsstrackerservice.feed.configuration.FeedConfiguration;
import com.hhovhann.rsstrackerservice.feed.dto.ResponseFeedDto;
import com.hhovhann.rsstrackerservice.feed.entity.RssFeed;
import com.hhovhann.rsstrackerservice.feed.exception.FeedContentParseException;
import com.hhovhann.rsstrackerservice.feed.mapper.FeedMapper;
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
    private final FeedMapper feedMapper;
    private final FeedConfiguration feedConfiguration;

    @Scheduled(fixedDelay = 600000)
    public void executeFeedContentReading() {
        log.debug("executeFeedContentReading");

        try {
            try (XmlReader reader = new XmlReader(new URL(feedConfiguration.getDomain()))) {
                SyndFeed feed = new SyndFeedInput().build(reader);
                var feedToStore = new ArrayList<RssFeed>();
                for (SyndEntry entry : feed.getEntries()) {
                    log.debug("Mapping current SyndEntry to RssFeed:{}", entry);

                    RssFeed rssFeed = feedMapper.toEntity(entry);
                    if (!feedService.isFeedExist(rssFeed)) {
                        feedToStore.add(rssFeed);
                    }
                }
                List<ResponseFeedDto> storedFeeds = feedService.storeFeeds(feedToStore);
                log.debug("Stored {} Feed(s) to local database", storedFeeds.size());
            }
        } catch (Exception e) {
            throw new FeedContentParseException("Something went wrong");
        }
    }
}
