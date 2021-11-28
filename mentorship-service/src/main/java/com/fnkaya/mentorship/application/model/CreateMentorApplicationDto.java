package com.fnkaya.mentorship.application.model;

import com.fnkaya.mentorship.application.domain.ApplicationStatus;
import com.fnkaya.mentorship.category.domain.Category;
import com.fnkaya.mentorship.common.model.Account;
import java.time.LocalDateTime;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import lombok.Data;

@Data
public class CreateMentorApplicationDto {

    @NotNull
    private Account owner;

    @NotBlank
    private String description;

    @NotEmpty
    private Category category;

    private ApplicationStatus status = ApplicationStatus.PENDING;

    private LocalDateTime date = LocalDateTime.now();
}
