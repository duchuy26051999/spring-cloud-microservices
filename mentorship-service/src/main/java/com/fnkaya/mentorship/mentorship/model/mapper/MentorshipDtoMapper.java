package com.fnkaya.mentorship.mentorship.model.mapper;

import com.fnkaya.mentorship.mentorship.model.CreateMentorshipDto;
import com.fnkaya.mentorship.mentorship.model.MentorshipDto;
import com.fnkaya.mentorship.mentorship.domain.Mentorship;
import org.mapstruct.Mapper;

@Mapper
public interface MentorshipDtoMapper {

    Mentorship fromDto(CreateMentorshipDto createMentorshipDto);
    MentorshipDto toDto(Mentorship mentorship);
}
