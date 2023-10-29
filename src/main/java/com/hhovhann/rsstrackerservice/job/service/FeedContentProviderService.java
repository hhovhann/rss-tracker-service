package com.hhovhann.rsstrackerservice.job.service;

import com.hhovhann.rsstrackerservice.entity.RssFeed;
import com.hhovhann.rsstrackerservice.service.FeedService;
import com.rometools.rome.feed.synd.SyndCategory;
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
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.List;

import static java.util.stream.Collectors.toList;

@Slf4j
@Service
@EnableScheduling
@RequiredArgsConstructor
@ConditionalOnProperty(name = "scheduler.enabled", matchIfMissing = true)
public class FeedContentProviderService {

    private final FeedService feedService;

    @Scheduled(fixedDelay = 600000)
    public void executeAll() {
        log.debug("Read RSS News and update the database .... .... ....");
        try {
//            String url = "http://localhost:8080/rss";  we can create our own rss localy and after all parse it
            String url = "http://rss.cnn.com/rss/cnn_latest.rss"; // all rescources here: https://edition.cnn.com/services/rss/
//            String url = "https://feeds.feedblitz.com/baeldung&x=1"; // all rescources here: https://edition.cnn.com/services/rss/

            try (XmlReader reader = new XmlReader(new URL(url))) {
                SyndFeed feed = new SyndFeedInput().build(reader);
                log.debug(feed.getTitle());
                log.debug("***********************************");
                var feedToStore = new ArrayList<RssFeed>();
                for (SyndEntry entry : feed.getEntries()) {
                    log.debug(entry + "");
                    log.debug("***********************************");

                    // TODO before add new Item need to have the way to check against existing records ...
                    // Configure local database item ....
                    RssFeed rssFeed = new RssFeed();
                    rssFeed.setTitle(entry.getTitle());
                    rssFeed.setLink(entry.getLink());
                    rssFeed.setDescription(entry.getDescription().getValue());
                    rssFeed.setPublicationDate(ZonedDateTime.ofInstant(entry.getPublishedDate().toInstant(), ZoneId.systemDefault()));
                    rssFeed.setAuthor(entry.getAuthor());
//                    rssFeed.setThumbnails(entry.getSource().getImage().getUrl()); // NEED TO CHECK/CHANGE
                    rssFeed.setThumbnails(feed.getImage().getUrl()); // NEED TO CHECK/CHANGE
                    // TODO add categories do smart and understood if need Category type with name, uri, etc fields or just simple string
                    rssFeed.setCategories(entry.getCategories()
                            .stream()
                            .map(SyndCategory::getName)
                            .toList());
                    rssFeed.setRelatedIdentifiers(entry.getUri());
                    rssFeed.setIsEnabled(true);

                    if (!feedService.isFeedExist(rssFeed)) {
                        feedToStore.add(rssFeed);
                    }
                }
                feedService.saveAllFeeds(feedToStore);
                log.debug("Done");
            }
        } catch (Exception e) {
            log.error("Done");
            throw new RuntimeException("Parse exceptipn");
        }
    }
}
