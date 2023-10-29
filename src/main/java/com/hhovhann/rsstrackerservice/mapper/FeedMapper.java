package com.hhovhann.rsstrackerservice.mapper;

import com.hhovhann.rsstrackerservice.dto.ResponseFeedDto;
import com.hhovhann.rsstrackerservice.entity.RssFeed;
import com.rometools.rome.feed.synd.SyndCategory;
import com.rometools.rome.feed.synd.SyndEntry;
import com.rometools.rome.feed.synd.SyndFeed;
import org.springframework.stereotype.Component;

import java.time.ZoneId;
import java.time.ZonedDateTime;

@Component
public class FeedMapper {

    public ResponseFeedDto toResponseDto(RssFeed updatedEntity) {
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

    public RssFeed toEntity(SyndEntry entry){
        RssFeed rssFeed = new RssFeed();
        rssFeed.setTitle(entry.getTitle());
        rssFeed.setLink(entry.getLink());
        rssFeed.setDescription(entry.getDescription().getValue());
        rssFeed.setPublicationDate(ZonedDateTime.ofInstant(entry.getPublishedDate().toInstant(), ZoneId.systemDefault()));
        rssFeed.setAuthor(entry.getAuthor());
        rssFeed.setThumbnails(""); // TODO NEED TO CHECK/CHANGE entry.getSource().getImage().getUrl() or something else should be stored here
        rssFeed.setCategories(entry.getCategories()
                .stream()
                .map(SyndCategory::getName)
                .toList());
        rssFeed.setRelatedIdentifiers(entry.getUri());

        return rssFeed;
    }
}
