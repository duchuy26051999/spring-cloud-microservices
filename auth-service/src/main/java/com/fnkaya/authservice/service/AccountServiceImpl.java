package com.fnkaya.authservice.service;

import com.fnkaya.authservice.repository.AccountRepository;
import com.fnkaya.authservice.service.domain.Account;
import com.fnkaya.authservice.service.mapper.AccountMapper;
import com.fnkaya.authservice.service.model.AccountDTO;
import com.fnkaya.authservice.service.model.AccountInput;
import java.util.List;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.context.annotation.Bean;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@CacheConfig(cacheNames = {"Account"})
@RequiredArgsConstructor
public class AccountServiceImpl implements AccountService {

    private final AccountRepository repository;
    private final AccountMapper mapper;
    private final PasswordEncoder passwordEncoder;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        return this.repository.findByEmail(email)
            .orElseThrow(() -> new UsernameNotFoundException(email));
    }

    @Override
    public AccountDTO findById(Long id) {
        return this.repository.findById(id).map(this.mapper::toDto)
            .orElseThrow(() -> new IllegalArgumentException(id + " değerine sahip bir hesap bulunamadı"));
    }

    @Override
    public List<AccountDTO> getAll() {
        List<Account> accounts = this.repository.findAll();
        return accounts.stream().map(mapper::toDto).collect(Collectors.toList());
    }

    @Override
    public void create(AccountInput input) {
        boolean existsByEmail = this.repository.existsByEmail(input.getEmail());
        if (existsByEmail) {
            throw new IllegalArgumentException(input.getEmail() + " bu mail adresi zaten var.");
        }
        input.setPassword(this.passwordEncoder.encode(input.getPassword()));
        this.repository.save(this.mapper.toEntity(input));
    }
}
