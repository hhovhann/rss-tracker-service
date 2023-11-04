package com.hhovhann.rsstrackerservice.feed.controller;

import com.hhovhann.rsstrackerservice.AbstractIntegrationTest;
import com.hhovhann.rsstrackerservice.feed.dto.RequestFeedDto;
import com.hhovhann.rsstrackerservice.feed.dto.ResponseFeedDto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.test.context.TestPropertySource;

import java.time.ZonedDateTime;
import java.util.List;
import java.util.Objects;

import static org.hibernate.validator.internal.util.Contracts.assertTrue;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

@TestPropertySource(properties = "scheduler.enabled=false")
class FeedEntityControllerTest extends AbstractIntegrationTest {

    @LocalServerPort
    private int port;

    private static final String BASE_URL = "/tracker/api/v1";

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    @DisplayName("Should find the feeds with existing categories and data range")
    void shouldFindFeedsWithCategoriesAndDataRanges() {
        // given
        var requestUrl = "http://localhost:" + port + "/" + BASE_URL + "/" + "feeds/search";
        var requestBody = new RequestFeedDto(List.of("best practices"), ZonedDateTime.now().minusYears(23), ZonedDateTime.now());

        // when
        var responseEntity = this.restTemplate.postForEntity(requestUrl, requestBody,ResponseFeedDto[].class);

        // then
        assertAll(
                "Grouped Assertions of Feeds",
                () -> assertTrue(responseEntity.hasBody(), "Response should has a body")
        );
    }

    @Test
    @DisplayName("Should not find the feeds with non existing categories and data range")
    void shouldNotFindFeedsWithCategoriesAndDataRanges() {
        var requestUrl = "http://localhost:" + port + "/" + BASE_URL + "/" + "feeds/search";
        var requestBody = new RequestFeedDto(List.of("worst practices"), ZonedDateTime.now().minusYears(23), ZonedDateTime.now());

        var responseEntity = this.restTemplate.postForEntity(requestUrl, requestBody,ResponseFeedDto[].class);

        assertAll(
                "Grouped Assertions of Feeds",
                () -> assertEquals(0, Objects.requireNonNull(responseEntity.getBody()).length, "Response should be with empty list")
        );
    }
}