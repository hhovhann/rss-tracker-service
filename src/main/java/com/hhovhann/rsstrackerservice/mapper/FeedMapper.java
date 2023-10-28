package com.hhovhann.rsstrackerservice.mapper;

import com.hhovhann.rsstrackerservice.dto.RequestFeedDto;
import com.hhovhann.rsstrackerservice.dto.ResponseFeedDto;
import com.hhovhann.rsstrackerservice.entity.Feed;
import org.springframework.stereotype.Component;

@Component
public class FeedMapper {

    public Feed toEntity(RequestFeedDto requestFeedDto) {
        // TODO here should be mapping business logic or can use mapstruct separate library

        Feed feed = new Feed();
        feed.setTitle(requestFeedDto.getTitle());
        feed.setLink(requestFeedDto.getLink());
        feed.setDescription(requestFeedDto.getDescription());

        return feed;
    }

    public ResponseFeedDto toDTO(Feed updatedEntity) {
        // TODO here should be mapping business logic or can use mapstruct separate library

        return new ResponseFeedDto(updatedEntity.getTitle(),updatedEntity.getLink(), updatedEntity.getDescription());
    }
}
