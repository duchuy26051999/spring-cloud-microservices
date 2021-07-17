package com.eteration.accountservice.service;

import com.eteration.accountservice.model.Account;
import com.eteration.accountservice.repository.AccountRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
@CacheConfig(cacheNames = {"Account"})
@RequiredArgsConstructor
public class AccountService {

    private final AccountRepository repository;

    @Cacheable(key = "#id")
    public Account get(Long id) {
        try {
            return repository.findById(id)
                    .orElseThrow(() -> new IllegalArgumentException("Verilen id değerine sahip bir kayıt bulunamadı."));
        }
        catch (IllegalArgumentException e) {
            log.error(e.getMessage());
        }

        return null;
    }

    public List<Account> getAll() {
        return repository.findAll();
    }

    public String create(Account account) {
        repository.save(account);
        return "Kayıt işlemi başarılı.";
    }

    public String createAll(List<Account> accountList) {
        repository.saveAll(accountList);
        return "Toplu kayıt işlemi başarılı.";
    }

    public Account update(Long id,Account account) {
        var accountDb = get(id);
        accountDb.setEmail(account.getEmail());
        accountDb.setPassword(account.getPassword());
        accountDb.setFullName(account.getFullName());
        accountDb.setAddress(account.getAddress());

        return repository.save(accountDb);
    }

    public String delete(Long id) {
        repository.delete(get(id));

        return "Kayıt başarıyla silindi.";
    }

    public String deleteAll(List<Long> idList) {
        List<Account> accountList = repository.findAllById(idList);
        repository.deleteAll(accountList);

        return "Tüm kayıtlar başarıyla silindi.";
    }
}
