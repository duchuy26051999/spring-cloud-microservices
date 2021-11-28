package com.fnkaya.mentorship.post.model.mapper;

import com.fnkaya.mentorship.post.domain.Post;
import com.fnkaya.mentorship.post.model.PostDto;
import org.mapstruct.Mapper;

@Mapper
public interface PostDtoMapper {

    PostDto toDto(Post post);
}
