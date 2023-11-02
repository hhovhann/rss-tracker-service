package com.hhovhann.rsstrackerservice.feed.repository;

import com.hhovhann.rsstrackerservice.feed.entity.FeedEntity;
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
class FeedEntityRepositoryTest {
    @Autowired
    FeedEntityRepository feedEntityRepository;

    @Test
    void shouldFindAllByCategoriesInIgnoreCaseAndPublicationDateBetween() {
        ZonedDateTime now = ZonedDateTime.now();
        ZonedDateTime afterTwoThousandsYears = now.plusYears(2000);

        List<FeedEntity> results = feedEntityRepository.findAllByCategoriesInIgnoreCaseAndPublicationDateBetween(Collections.singletonList("JAVA"), now, afterTwoThousandsYears);

        assertEquals(1, results.size());
    }

}