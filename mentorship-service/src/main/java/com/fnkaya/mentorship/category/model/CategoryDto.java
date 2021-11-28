package com.fnkaya.mentorship.category.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class CategoryDto {

    private Long id;

    private String name;
}
