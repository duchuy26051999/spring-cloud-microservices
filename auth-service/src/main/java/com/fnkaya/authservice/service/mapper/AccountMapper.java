package com.fnkaya.authservice.service.mapper;

import com.fnkaya.authservice.service.domain.Account;
import com.fnkaya.authservice.service.model.AccountDTO;
import com.fnkaya.authservice.service.model.AccountInput;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = {AuthorityMapper.class})
public interface AccountMapper {

    Account toEntity(AccountInput input);
    AccountDTO toDto(Account account);
}
