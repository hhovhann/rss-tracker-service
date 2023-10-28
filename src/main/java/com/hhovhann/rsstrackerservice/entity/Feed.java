package com.hhovhann.rsstrackerservice.entity;

import com.hhovhann.rsstrackerservice.enumes.Category;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

import java.time.ZonedDateTime;
import java.util.List;

@Table
@Entity
@Getter
@Setter
public class Feed {
    @Id
    @GeneratedValue
    private Long id;
    String title;
    String link;
    String description;
    ZonedDateTime publicationDate;
    @Embedded
    Author author;
    String thumbnails; // link to thumbnails url
    @Enumerated(EnumType.STRING)
    Category category;
    @ElementCollection
    List<Long> relatedIdentifiers; // <id>urn:uuid:1225c695-cfb8-4ebb-aaaa-80da344efa6a</id>
}
