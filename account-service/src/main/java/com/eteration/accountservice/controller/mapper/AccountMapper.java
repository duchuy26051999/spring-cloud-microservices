package com.eteration.accountservice.controller.mapper;

import com.eteration.accountservice.controller.dto.AccountRequestDto;
import com.eteration.accountservice.controller.dto.AccountResponseDto;
import com.eteration.accountservice.model.Account;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper
public interface AccountMapper {

    Account fromDto(AccountRequestDto dto);
    AccountResponseDto toDto(Account account);
    List<Account> fromDtoList(List<AccountRequestDto> dtoList);
    List<AccountResponseDto> toDtoList(List<Account> accountList);
}
