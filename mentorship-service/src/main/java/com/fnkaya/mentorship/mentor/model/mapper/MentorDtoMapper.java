package com.fnkaya.mentorship.mentor.model.mapper;

import com.fnkaya.mentorship.mentor.model.MentorDto;
import com.fnkaya.mentorship.mentor.domain.Mentor;
import org.mapstruct.Mapper;

@Mapper
public interface MentorDtoMapper {

    MentorDto toDto(Mentor mentor);
}
