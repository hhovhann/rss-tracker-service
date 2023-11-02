package com.hhovhann.rsstrackerservice.feed.service.entity;

import com.hhovhann.rsstrackerservice.feed.entity.FeedEntity;
import com.hhovhann.rsstrackerservice.feed.repository.FeedEntityRepository;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@SpringBootTest
class FeedEntityServiceTest {

    @Autowired
    FeedEntityService feedEntityService;

    @Mock
    FeedEntityRepository feedEntityRepository;

    @Test
    void test1 (){
        // given
        var feed = new FeedEntity();
        when(feedEntityRepository.exists(Example.of(feed, ExampleMatcher.matchingAll()))).thenReturn(true);
        // when
        boolean feedExist = feedEntityService.isFeedExist(feed);
        //then
        assertTrue(feedExist);
    }

}