package com.fnkaya.authservice.service.mapper;

import com.fnkaya.authservice.domain.Account;
import com.fnkaya.authservice.service.model.AccountDTO;
import com.fnkaya.authservice.service.model.AccountInput;
import org.mapstruct.Mapper;

@Mapper
public interface AccountMapper {

    Account toEntity(AccountInput input);
    AccountDTO toDto(Account account);
}
