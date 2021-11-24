package com.blogApp.blog.services.mapper;

import com.blogApp.blog.data.dto.PostUpdateDto;
import com.blogApp.blog.data.model.Post;
import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

@Mapper(componentModel = "spring")
public interface PostMapper {
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    public Post mapPostDtoToPost(PostUpdateDto postUpdateDto, @MappingTarget Post post);
}
