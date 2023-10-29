package com.hhovhann.rsstrackerservice.entity;

import com.hhovhann.rsstrackerservice.enumes.FeedCategory;
import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.Table;
import jdk.jfr.Category;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.ZonedDateTime;
import java.util.List;

@Table
@Entity
@Getter
@Setter
@NoArgsConstructor
public class RssFeed {
    @Id
    @GeneratedValue
    private Long id;
    String title;
    String link;
    @Lob
    @Column(name = "CONTENT", length = 512)
    String description;
    ZonedDateTime publicationDate;
    String author;
    String thumbnails; // link to thumbnails url: in Channel it's Image with size url etc ....
    @Enumerated(EnumType.STRING)
    FeedCategory feedCategory;
    @ElementCollection
    List<String> categories;
    String relatedIdentifiers;
}
