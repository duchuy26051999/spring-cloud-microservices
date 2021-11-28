package com.fnkaya.mentorship.category.model.mapper;

import com.fnkaya.mentorship.category.domain.Category;
import com.fnkaya.mentorship.category.model.CategoryDto;
import com.fnkaya.mentorship.category.model.CategoryInput;
import org.mapstruct.Mapper;

@Mapper
public interface CategoryMapper {

    CategoryDto toDto(Category category);
    Category toEntity(CategoryInput categoryInput);
}
