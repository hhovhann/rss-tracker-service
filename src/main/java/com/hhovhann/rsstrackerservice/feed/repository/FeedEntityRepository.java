package com.hhovhann.rsstrackerservice.feed.repository;

import com.hhovhann.rsstrackerservice.feed.entity.FeedEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.ZonedDateTime;
import java.util.List;

@Repository
public interface FeedEntityRepository extends JpaRepository<FeedEntity, Long> {

    /***
     * Search collection of enabled feeds by categories and date ranges
     * @param categories categories
     * @param dateFrom start date
     * @param dateTo end date
     * @return collection of feed entity matching query conditions, otherwise empty collections
     */
    List<FeedEntity> findByCategoriesInAndPublicationDateBetween(List<String> categories, ZonedDateTime dateFrom, ZonedDateTime dateTo);

}
