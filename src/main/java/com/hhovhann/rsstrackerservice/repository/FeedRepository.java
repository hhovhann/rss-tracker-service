package com.hhovhann.rsstrackerservice.repository;

import com.hhovhann.rsstrackerservice.entity.RssFeed;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.ZonedDateTime;
import java.util.List;

@Repository
public interface FeedRepository extends JpaRepository<RssFeed, Long> {
    List<RssFeed> findAllByIsEnabledAndPublicationDateBetween(Boolean isEnabled, ZonedDateTime dateFrom, ZonedDateTime dateTo);

    List<RssFeed> findAllByCategoriesIsInAndIsEnabledAndPublicationDateBetween(List<String> categories,
                                                                               Boolean isEnabled,
                                                                               ZonedDateTime dateFrom,
                                                                               ZonedDateTime dateTo);

    List<RssFeed> findAllByIsEnabledOrderByCategoriesAscPublicationDateAsc(Boolean isEnabled);

}
