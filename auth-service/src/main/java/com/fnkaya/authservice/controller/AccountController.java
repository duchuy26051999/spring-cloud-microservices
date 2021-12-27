package com.fnkaya.authservice.controller;

import com.fnkaya.authservice.service.model.AccountDTO;
import com.fnkaya.authservice.service.model.AccountInput;
import com.fnkaya.authservice.service.AccountServiceImpl;
import java.util.List;
import java.util.Map;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("auth")
@RequiredArgsConstructor
public class AccountController {

    private final AccountServiceImpl service;

    @GetMapping(value = "{id}")
    public ResponseEntity<AccountDTO> get(@PathVariable(value = "id") Long id) {
        return ResponseEntity.ok(this.service.findById(id));
    }

    @GetMapping
    public ResponseEntity<Map<String, List<AccountDTO>>> getAll() {
        return ResponseEntity.ok(Map.of("accountList", this.service.getAll()));
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void create(@RequestBody AccountInput input) {
        this.service.create(input);
    }
}
