package com.hhovhann.rsstrackerservice.feed.controller;

import com.hhovhann.rsstrackerservice.feed.dto.ResponseFeedDto;
import com.hhovhann.rsstrackerservice.feed.dto.SearchFeedDto;
import com.hhovhann.rsstrackerservice.feed.service.FeedService;
import com.rometools.rome.feed.atom.Entry;
import com.rometools.rome.feed.atom.Feed;
import com.rometools.rome.feed.atom.Link;
import com.rometools.rome.feed.atom.Person;
import com.rometools.rome.feed.rss.Category;
import com.rometools.rome.feed.rss.Channel;
import com.rometools.rome.feed.rss.Description;
import com.rometools.rome.feed.rss.Image;
import com.rometools.rome.feed.rss.Item;
import com.rometools.rome.feed.synd.SyndPerson;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.Date;
import java.util.List;

@Slf4j
@RestController
@RequestMapping("/tracker/api/v1")
@RequiredArgsConstructor
public class FeedController {

    private final FeedService feedService;

    @PostMapping("/feeds/search")
    public ResponseEntity<List<ResponseFeedDto>> searchFeeds(@RequestBody @Valid SearchFeedDto searchFeedDto) {
        log.debug("searchFeeds, searchFeedDto: {}", searchFeedDto);

        return ResponseEntity.ok(feedService.searchFeedsByCategoriesAndDateRange(searchFeedDto.categories(), searchFeedDto.dateFrom(), searchFeedDto.dateTo()));
    }

    @GetMapping(path = "/rss")
    @Deprecated(since = "1.0.0")
    public Channel rss() {
        log.debug("rss");

        Channel channel = new Channel();
        channel.setFeedType("rss_2.0");
        channel.setTitle("HowToDoInJava RssFeed");
        channel.setDescription("Different Articles on latest technology");
        channel.setLink("https://howtodoinjava.com");
        channel.setUri("https://howtodoinjava.com");
        channel.setGenerator("In House Programming");

        // Thumbnails
        Image image = new Image();
        image.setUrl("https://howtodoinjava.com/wp-content/uploads/2015/05/howtodoinjava_logo-55696c1cv1_site_icon-32x32.png");
        image.setTitle("HowToDoInJava RssFeed");
        image.setHeight(32);
        image.setWidth(32);
        channel.setImage(image);

        Date postDate = new Date();
        channel.setPubDate(postDate);

        Item item = new Item();
        item.setAuthor("Lokesh Gupta");
        item.setLink("https://howtodoinjava.com/spring5/webmvc/spring-mvc-cors-configuration/");
        item.setTitle("Spring CORS Configuration Examples");
        item.setUri("https://howtodoinjava.com/spring5/webmvc/spring-mvc-cors-configuration/");
        item.setComments("https://howtodoinjava.com/spring5/webmvc/spring-mvc-cors-configuration/#respond");

        Category category = new Category();
        category.setValue("CORS");
        item.setCategories(Collections.singletonList(category));

        Description descr = new Description();
        descr.setValue(
                """
                        CORS helps in serving web content from multiple domains into browsers who usually have the same-origin security policy. In this example, we will learn to enable CORS support in Spring MVC application at method and global level.
                        The post <a rel="nofollow" href="https://howtodoinjava.com/spring5/webmvc/spring-mvc-cors-configuration/">Spring CORS Configuration Examples</a> appeared first on <a rel="nofollow" href="https://howtodoinjava.com">HowToDoInJava</a>.
                        """
        );
        item.setDescription(descr);
        item.setPubDate(postDate);

        channel.setItems(Collections.singletonList(item));
        //Like more Entries here about different new topics
        return channel;
    }

    @GetMapping(path = "/atom")
    @Deprecated(since = "1.0.0")
    public Feed atom() {
        log.debug("atom");

        // Atom Feed
        Feed feed = new Feed();
        feed.setFeedType("atom_1.0");
        feed.setTitle("HowToDoInJava");
        feed.setId("https://howtodoinjava.com");
        // Content ....
        com.rometools.rome.feed.atom.Content subtitle = new com.rometools.rome.feed.atom.Content();
        subtitle.setType("text/plain");
        subtitle.setValue("Different Articles on latest technology");
        feed.setSubtitle(subtitle);

        Date postDate = new Date();
        feed.setUpdated(new Date());

        Entry entry = new Entry();

        Link link = new Link();
        link.setHref("https://howtodoinjava.com/spring5/webmvc/spring-mvc-cors-configuration/");
        entry.setAlternateLinks(Collections.singletonList(link));
        SyndPerson author = new Person();
        author.setName("Lokesh Gupta");
        entry.setAuthors(Collections.singletonList(author));
        entry.setCreated(postDate);
        entry.setPublished(postDate);
        entry.setUpdated(postDate);
        entry.setId("https://howtodoinjava.com/spring5/webmvc/spring-mvc-cors-configuration/");
        entry.setTitle("spring-mvc-cors-configuration");
        com.rometools.rome.feed.atom.Category category = new com.rometools.rome.feed.atom.Category();
        category.setTerm("CORS");
        entry.setCategories(Collections.singletonList(category));

        com.rometools.rome.feed.atom.Content summary = new com.rometools.rome.feed.atom.Content();
        summary.setType("text/plain");
        summary.setValue(
                "CORS helps in serving web content from multiple domains into browsers who usually have the same-origin security policy. In this example, we will learn to enable CORS support in Spring MVC application at method and global level."
                        + "The post <a rel=\"nofollow\" href=\"https://howtodoinjava.com/spring5/webmvc/spring-mvc-cors-configuration/\">Spring CORS Configuration Examples</a> appeared first on <a rel=\"nofollow\" href=\"https://howtodoinjava.com\">HowToDoInJava</a>.");
        entry.setSummary(summary);

        feed.setEntries(Collections.singletonList(entry));
        //Like more Entries here about different new topics
        return feed;
    }
}
