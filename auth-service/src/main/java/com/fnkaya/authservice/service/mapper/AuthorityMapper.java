package com.fnkaya.authservice.service.mapper;

import com.fnkaya.authservice.service.domain.Authority;
import com.fnkaya.authservice.service.model.AuthorityDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface AuthorityMapper {

    AuthorityDTO toDto(Authority authority);
}
