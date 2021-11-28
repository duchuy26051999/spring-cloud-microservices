package com.fnkaya.mentorship.mentorship.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fnkaya.mentorship.category.model.CategoryDto;
import com.fnkaya.mentorship.mentorship.domain.MentorshipStatus;
import java.time.LocalDateTime;
import java.util.List;
import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class MentorshipDto {

    private String id;

    private MentorDto mentor;

    private AccountDto mentee;

    private LocalDateTime startDate;

    private CategoryDto category;

    private List<PhaseDto> phases;

    private MentorshipStatus status;
}
