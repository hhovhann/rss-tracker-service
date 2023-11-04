package com.hhovhann.rsstrackerservice.feed.controller;

import com.hhovhann.rsstrackerservice.feed.dto.RequestFeedDto;
import com.hhovhann.rsstrackerservice.feed.dto.ResponseFeedDto;
import com.hhovhann.rsstrackerservice.feed.exception.RateLimitingException;
import com.hhovhann.rsstrackerservice.feed.service.entity.FeedEntityService;
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
import io.github.resilience4j.ratelimiter.RequestNotPermitted;
import io.github.resilience4j.ratelimiter.annotation.RateLimiter;
import io.github.resilience4j.ratelimiter.event.RateLimiterEvent;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.ErrorResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.ZonedDateTime;
import java.util.Collections;
import java.util.Date;
import java.util.List;

@Slf4j
@RestController
@RequestMapping("/tracker/api/v1")
@RequiredArgsConstructor
public class FeedEntityController {

    private final FeedEntityService feedEntityService;
    private static final String SERVICE_NAME = "rss-tracker-service";
    @GetMapping("/feeds/search")
    @RateLimiter(name = SERVICE_NAME, fallbackMethod = "fallbackMethod")
    public ResponseEntity<List<ResponseFeedDto>> getFeeds(@RequestParam("categories") List<String> categories, @RequestParam("dataFrom") ZonedDateTime dateFrom, @RequestParam("dateTo") ZonedDateTime dateTo) {
        log.debug("getFeeds, categories: {}, dateFrom: {}, dateTo: {}", categories, dateFrom, dateTo);

        return ResponseEntity.ok(feedEntityService.searchFeedsByCategoriesAndDateRange(categories, dateFrom, dateTo));
    }

    @PostMapping("/feeds/search")
    @RateLimiter(name = SERVICE_NAME, fallbackMethod = "fallbackMethod")
    public ResponseEntity<List<ResponseFeedDto>> searchFeeds(@RequestBody @Valid RequestFeedDto requestFeedDto) {
        log.debug("searchFeeds, requestFeedDto: {}", requestFeedDto);

        return ResponseEntity.ok(feedEntityService.searchFeedsByCategoriesAndDateRange(requestFeedDto.categories(), requestFeedDto.dateFrom(), requestFeedDto.dateTo()));
    }
    private ResponseEntity<ErrorResponse> fallbackMethod(RequestNotPermitted requestNotPermitted) {
        throw new RateLimitingException("Rss Tracker service does not permit further calls");
    }
}
