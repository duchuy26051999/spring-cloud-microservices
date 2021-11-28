package com.fnkaya.mentorship.mentorship.model;

import com.fnkaya.mentorship.category.model.CategoryDto;
import com.fnkaya.mentorship.common.model.Account;
import com.fnkaya.mentorship.mentor.domain.Mentor;
import javax.validation.constraints.NotNull;
import lombok.Data;

@Data
public class CreateMentorshipDto {

    @NotNull
    private Mentor mentor;

    @NotNull
    private Account mentee;

    @NotNull
    private CategoryDto category;
}
