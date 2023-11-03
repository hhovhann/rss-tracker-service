package com.hhovhann.rsstrackerservice.feed.controller;

import com.hhovhann.rsstrackerservice.AbstractIntegrationTest;
import com.hhovhann.rsstrackerservice.feed.dto.RequestFeedDto;
import com.hhovhann.rsstrackerservice.feed.dto.ResponseFeedDto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.test.context.TestPropertySource;

import java.time.ZonedDateTime;
import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

@TestPropertySource(properties = "scheduler.enabled=false")
class FeedEntityControllerTest extends AbstractIntegrationTest {

    @LocalServerPort
    private int port;

    private static final String BASE_URL = "/tracker/api/v1";

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    void getFeedsByFilters() throws Exception {
        var requestUrl = "http://localhost:" + port + "/" + BASE_URL + "/" + "feeds/search";
        assertThat(this.restTemplate.getForEntity(
                requestUrl,
                ResponseFeedDto.class,
                Map.of("categories", List.of(), "dateFrom", ZonedDateTime.now(), "dateTo", ZonedDateTime.now().plusDays(10))));
    }

    @Test
    void searchFeeds() throws Exception {
        var requestUrl = "http://localhost:" + port + "/" + BASE_URL + "/" + "feeds/search";
        assertThat(this.restTemplate.postForEntity(
                requestUrl,
                new RequestFeedDto(List.of(), ZonedDateTime.now(), ZonedDateTime.now().plusDays(10)),
                ResponseFeedDto.class));
    }
}