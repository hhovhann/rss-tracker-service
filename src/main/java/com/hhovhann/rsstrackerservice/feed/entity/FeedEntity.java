package com.hhovhann.rsstrackerservice.feed.entity;

import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class FeedEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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
}
