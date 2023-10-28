package com.hhovhann.rsstrackerservice.repository;

import com.hhovhann.rsstrackerservice.entity.Feed;
import com.hhovhann.rsstrackerservice.enumes.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.ListCrudRepository;

import java.time.ZonedDateTime;
import java.util.List;

public interface FeedRepository extends ListCrudRepository<Long, Feed>, JpaRepository<Long, Feed> {
    List<Feed> findAllByCategoryAndPublicationTimeBetween(ZonedDateTime dateFrom, ZonedDateTime dateTo, Category category);

}
