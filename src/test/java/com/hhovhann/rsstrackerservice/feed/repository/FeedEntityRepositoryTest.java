package com.hhovhann.rsstrackerservice.feed.repository;

import com.hhovhann.rsstrackerservice.AbstractIntegrationTest;
import com.hhovhann.rsstrackerservice.feed.entity.FeedEntity;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;

import java.time.ZonedDateTime;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@TestPropertySource(properties = "scheduler.enabled=false")
class FeedEntityRepositoryTest extends AbstractIntegrationTest {
    @Autowired
    FeedEntityRepository feedEntityRepository;

    @Test
    @DisplayName("Should find all Feeds by categories in and publicationDate is between Date from and Date to")
    void shouldFindAllByCategoriesInAndPublicationDateBetween() {
        ZonedDateTime now = ZonedDateTime.now();
        ZonedDateTime afterTwoThousandsYears = now.plusYears(2000);

        List<FeedEntity> results = feedEntityRepository.findAllByCategoriesInAndPublicationDateBetween(Collections.singletonList("JAVA"), now, afterTwoThousandsYears);

        assertEquals(0, results.size());
    }

}