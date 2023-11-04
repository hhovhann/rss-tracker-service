package com.hhovhann.rsstrackerservice.feed.repository;

import com.hhovhann.rsstrackerservice.feed.entity.FeedConfiguration;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FeedConfigurationRepository extends JpaRepository<FeedConfiguration, Long> {
    /**
     * Search collection of enabled feeds by categories and date ranges
     * @return collection of enabled feed configuration
     */
    List<FeedConfiguration> findAllByIngestionEnableTrue();

}
