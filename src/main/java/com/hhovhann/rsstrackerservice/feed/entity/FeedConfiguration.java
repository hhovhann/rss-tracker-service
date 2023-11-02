package com.hhovhann.rsstrackerservice.feed.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Table
@Entity
@Getter
@Setter
@NoArgsConstructor
public class FeedConfiguration {
    @Id
    @GeneratedValue
    private Long id;
    private String domain;
    Boolean ingestionEnable;
}