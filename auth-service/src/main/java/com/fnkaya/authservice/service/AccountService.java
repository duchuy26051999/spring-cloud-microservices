package com.fnkaya.authservice.service;

import com.fnkaya.authservice.service.model.AccountDTO;
import com.fnkaya.authservice.service.model.AccountInput;
import java.util.List;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface AccountService extends UserDetailsService {

    AccountDTO findById(Long id);

    List<AccountDTO> getAll();

    void create(AccountInput input);
}
