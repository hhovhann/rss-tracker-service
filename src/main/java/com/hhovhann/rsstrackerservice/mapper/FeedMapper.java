package com.hhovhann.rsstrackerservice.mapper;

import com.hhovhann.rsstrackerservice.dto.RequestFeedDto;
import com.hhovhann.rsstrackerservice.dto.ResponseFeedDto;
import com.hhovhann.rsstrackerservice.entity.RssFeed;
import org.springframework.stereotype.Component;

@Component
public class FeedMapper {

    public RssFeed toEntity(RequestFeedDto requestFeedDto) {
        // TODO here should be mapping business logic or can use mapstruct separate library

        RssFeed rssFeed = new RssFeed();
        rssFeed.setTitle(requestFeedDto.title());
        rssFeed.setLink(requestFeedDto.link());
        rssFeed.setDescription(requestFeedDto.description());

        return rssFeed;
    }

    public ResponseFeedDto toDTO(RssFeed updatedEntity) {
        // TODO here should be mapping business logic or can use mapstruct separate library

        return new ResponseFeedDto(updatedEntity.getTitle(),updatedEntity.getLink(), updatedEntity.getDescription());
    }
}
