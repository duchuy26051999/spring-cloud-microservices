package com.eteration.accountservice.controller;

import com.eteration.accountservice.controller.dto.AccountRequestDto;
import com.eteration.accountservice.controller.dto.AccountResponseDto;
import com.eteration.accountservice.controller.mapper.AccountMapper;
import com.eteration.accountservice.controller.path.ApiPath;
import com.eteration.accountservice.service.AccountService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(ApiPath.ACCOUNT_URL)
@RequiredArgsConstructor
public class AccountController {

    private final AccountService service;
    private final AccountMapper mapper;

    @GetMapping(value = "{id}")

    public ResponseEntity<AccountResponseDto> get(@PathVariable(value = "id") Long id) {
        var dto = mapper.toDto(service.get(id));

        return ResponseEntity.ok(dto);
    }

    @GetMapping
    public ResponseEntity<Map<String, List<AccountResponseDto>>> getAll() {
        List<AccountResponseDto> dtoList = mapper.toDtoList(service.getAll());

        return ResponseEntity.ok(Map.of("accountList", dtoList));
    }

    @PostMapping
    public ResponseEntity<String> create(@RequestBody AccountRequestDto dto) {
        String response = service.create(mapper.fromDto(dto));

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(response);
    }

    @PostMapping(value = "list")
    public ResponseEntity<String> createAll(@RequestBody Map<String, List<AccountRequestDto>> map) {
        String response = service.createAll(mapper.fromDtoList(map.get("accountList")));

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(response);
    }

    @PutMapping(value = "{id}")
    public ResponseEntity<AccountResponseDto> update(@PathVariable("id") Long id,@RequestBody AccountRequestDto dto) {
        var uAccount = service.update(id, mapper.fromDto(dto));

        return ResponseEntity.ok(mapper.toDto(uAccount));
    }

    @DeleteMapping(value = "{id}")
    public ResponseEntity<String> delete(@PathVariable("id") Long id) {
        String response = service.delete(id);

        return ResponseEntity.ok(response);
    }

    @DeleteMapping
    public ResponseEntity<String> deleteAll(@RequestBody List<Long> idList) {
        String response = service.deleteAll(idList);

        return ResponseEntity.ok(response);
    }
}
