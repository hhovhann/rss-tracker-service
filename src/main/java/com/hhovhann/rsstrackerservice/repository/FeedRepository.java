package com.hhovhann.rsstrackerservice.repository;

import com.hhovhann.rsstrackerservice.entity.RssFeed;
import com.hhovhann.rsstrackerservice.enumes.FeedCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.ZonedDateTime;
import java.util.List;

@Repository
public interface FeedRepository extends JpaRepository<RssFeed, Long> {
    List<RssFeed> findAllByFeedCategoryAndPublicationDateBetween( FeedCategory feedCategory, ZonedDateTime dateFrom, ZonedDateTime dateTo);

}
