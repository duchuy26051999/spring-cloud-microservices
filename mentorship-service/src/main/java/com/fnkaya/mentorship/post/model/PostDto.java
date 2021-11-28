package com.fnkaya.mentorship.post.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fnkaya.mentorship.category.model.CategoryDto;
import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class PostDto {

    private String id;

    private MentorDto owner;

    private CategoryDto category;

    private String description;
}
