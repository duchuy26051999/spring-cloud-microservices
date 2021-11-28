package com.fnkaya.mentorship.application.model.mapper;

import com.fnkaya.mentorship.application.model.CreateMentorApplicationDto;
import com.fnkaya.mentorship.application.model.MentorApplicationDto;
import com.fnkaya.mentorship.application.domain.MentorApplication;
import org.mapstruct.Mapper;

@Mapper
public interface MentorApplicationDtoMapper {

    MentorApplication fromDto(CreateMentorApplicationDto createMentorApplicationDto);
    MentorApplicationDto toDto(MentorApplication mentorApplication);
}
