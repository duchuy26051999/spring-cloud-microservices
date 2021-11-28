package com.fnkaya.mentorship.application.model;

import com.fnkaya.mentorship.application.domain.ApplicationStatus;
import com.fnkaya.mentorship.category.model.CategoryDto;
import java.time.LocalDateTime;
import lombok.Data;

@Data
public class MentorApplicationDto {

    private String id;

    private OwnerDto owner;

    private CategoryDto category;

    private String description;

    private ApplicationStatus status;

    private LocalDateTime date;
}
