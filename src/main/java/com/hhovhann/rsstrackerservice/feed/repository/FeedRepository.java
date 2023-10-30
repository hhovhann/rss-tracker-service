package com.hhovhann.rsstrackerservice.feed.repository;

import com.hhovhann.rsstrackerservice.feed.entity.RssFeed;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.ZonedDateTime;
import java.util.List;

@Repository
public interface FeedRepository extends JpaRepository<RssFeed, Long> {
    List<RssFeed> findAllByPublicationDateBetween(ZonedDateTime dateFrom, ZonedDateTime dateTo);

    List<RssFeed> findAllByCategoriesContainingIgnoreCaseAndPublicationDateBetween(String category, ZonedDateTime dateFrom, ZonedDateTime dateTo);

}
