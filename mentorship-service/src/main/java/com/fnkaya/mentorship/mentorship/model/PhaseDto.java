package com.fnkaya.mentorship.mentorship.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fnkaya.mentorship.mentorship.domain.Comment;
import com.fnkaya.mentorship.mentorship.domain.PhaseStatus;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class PhaseDto {

    private String id;

    private String name;

    private LocalDateTime endDate;

    private Comment mentorComment;

    private Comment menteeComment;

    private PhaseStatus status;
}
