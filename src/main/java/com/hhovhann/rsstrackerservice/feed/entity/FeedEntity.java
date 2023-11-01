package com.hhovhann.rsstrackerservice.feed.entity;

import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.List;

@Table
@Entity
@Getter
@Setter
@NoArgsConstructor
public class FeedEntity {
    @Id
    @GeneratedValue
    private Long id;
    String title;
    String link;
    @Lob
    @Column(name = "description", length = 512)
    String description;
    ZonedDateTime publicationDate;
    String author;
    String thumbnails;
    @ElementCollection
    List<String> categories = new ArrayList<>();
    String relatedIdentifiers;
    Boolean isEnabled;
}
