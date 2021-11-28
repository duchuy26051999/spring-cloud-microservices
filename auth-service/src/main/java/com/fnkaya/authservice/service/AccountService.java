package com.fnkaya.authservice.service;

import com.fnkaya.authservice.service.model.AccountDTO;
import com.fnkaya.authservice.service.model.AccountInput;
import java.util.List;

public interface AccountService{

    AccountDTO findById(Long id);

    List<AccountDTO> getAll();

    void create(AccountInput input);
}
