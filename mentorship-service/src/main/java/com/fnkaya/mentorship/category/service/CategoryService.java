package com.fnkaya.mentorship.category.service;

import com.fnkaya.mentorship.category.model.CategoryDto;
import com.fnkaya.mentorship.category.model.CategoryInput;
import java.util.List;

public interface CategoryService {

    CategoryDto save(CategoryInput categoryInput);

    CategoryDto getById(Long id);

    List<CategoryDto> getAll();
    void delete(Long id);
}
