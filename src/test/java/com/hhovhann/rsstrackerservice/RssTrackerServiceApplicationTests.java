package com.hhovhann.rsstrackerservice;

import com.hhovhann.rsstrackerservice.feed.controller.FeedEntityController;
import org.junit.Ignore;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
class RssTrackerServiceApplicationTests {

    @Autowired
    private FeedEntityController controller;

    @Test
    void contextLoads() {
        assertThat(controller).isNotNull();
    }
}
