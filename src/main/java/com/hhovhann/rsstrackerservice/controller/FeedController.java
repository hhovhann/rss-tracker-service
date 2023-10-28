package com.hhovhann.rsstrackerservice.controller;

import com.hhovhann.rsstrackerservice.dto.RequestFeedDto;
import com.hhovhann.rsstrackerservice.dto.ResponseFeedDto;
import com.hhovhann.rsstrackerservice.enumes.Category;
import com.hhovhann.rsstrackerservice.service.FeedService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.ZonedDateTime;
import java.util.List;

@Slf4j
@Validated
@RestController("/rss/api/v1/")
@RequiredArgsConstructor
public class FeedController {

    private final FeedService feedService;

    @PostMapping("feeds")
    ResponseEntity<List<Long>> addFeeds(@RequestBody List<RequestFeedDto> feeds) {
        log.debug("addFeeds, feeds: {}", feeds);

        return ResponseEntity.ok(feedService.createFeeds(feeds));
    }

    @GetMapping("feeds/category")
    ResponseEntity<List<ResponseFeedDto>> getFeedsByDateRangeAndCategories(@RequestParam ZonedDateTime dateFrom, @RequestParam ZonedDateTime dateTo, @RequestParam String category) {
        log.debug("getFeedsByDateRangeAndCategories, dateFrom: {}, dateTo: {}, category: {}", dateFrom, dateTo, category);

        return ResponseEntity.ok(feedService.getFeedsByDateRangeAndCategory(dateFrom, dateTo, Category.valueOf(category)));
    }

}
