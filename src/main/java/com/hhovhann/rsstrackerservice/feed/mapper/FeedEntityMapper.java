package com.hhovhann.rsstrackerservice.feed.mapper;

import com.hhovhann.rsstrackerservice.feed.dto.ResponseFeedDto;
import com.hhovhann.rsstrackerservice.feed.entity.FeedEntity;
import com.rometools.rome.feed.synd.SyndCategory;
import com.rometools.rome.feed.synd.SyndEntry;
import com.rometools.rome.feed.synd.SyndLink;
import org.springframework.stereotype.Component;

import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Objects;

@Component
public class FeedEntityMapper {

    public ResponseFeedDto toResponseDto(FeedEntity updatedEntity) {
        return new ResponseFeedDto(
                updatedEntity.getTitle(),
                updatedEntity.getLink(),
                updatedEntity.getDescription(),
                updatedEntity.getPublicationDate(),
                updatedEntity.getAuthor(),
                updatedEntity.getThumbnails(),
                updatedEntity.getCategories(),
                updatedEntity.getRelatedIdentifiers());
    }

    public FeedEntity toEntity(SyndEntry entry) {
        FeedEntity feedEntity = new FeedEntity();
        feedEntity.setTitle(entry.getTitle());
        feedEntity.setLink(entry.getLink());
        feedEntity.setDescription(entry.getDescription().getValue());
        feedEntity.setPublicationDate(ZonedDateTime.ofInstant(entry.getPublishedDate().toInstant(), ZoneId.systemDefault()));
        feedEntity.setAuthor(entry.getAuthor());
        feedEntity.setThumbnails(Objects.requireNonNullElse(entry.getSource().getIcon().getUrl(), "entry.getSource().getImage().getUrl()"));
        feedEntity.setCategories(entry.getCategories()
                .stream()
                .map(SyndCategory::getName)
                .toList());
        feedEntity.setRelatedIdentifiers(entry.getLinks()
                .stream()
                .map(SyndLink::getHref)
                .toList());

        return feedEntity;
    }
}
