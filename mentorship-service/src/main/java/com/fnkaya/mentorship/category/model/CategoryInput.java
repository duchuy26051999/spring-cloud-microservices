package com.fnkaya.mentorship.category.model;

import javax.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class CategoryInput {

    @NotBlank(message = "Kategori ismi boş olamaz")
    private String name;

    private CategoryDto parent;
}
