package com.fnkaya.mentorship.category.controller;

import com.fnkaya.mentorship.category.model.CategoryDto;
import com.fnkaya.mentorship.category.model.CategoryInput;
import com.fnkaya.mentorship.category.service.CategoryService;
import java.util.List;
import javax.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "api/category")
@RequiredArgsConstructor
public class CategoryController {

    private final CategoryService service;

    @PostMapping
    public ResponseEntity<CategoryDto> save(@RequestBody @Valid CategoryInput categoryInput) {
        return ResponseEntity.status(HttpStatus.CREATED).body(this.service.save(categoryInput));
    }

    @GetMapping(value = "{id}")
    public ResponseEntity<CategoryDto> get(@PathVariable(name = "id") Long id) {
        return ResponseEntity.ok(this.service.getById(id));
    }

    @GetMapping
    public ResponseEntity<List<CategoryDto>> getAll() {
        return ResponseEntity.ok(this.service.getAll());
    }

    @PutMapping()
    public ResponseEntity<CategoryDto> update(@RequestBody @Valid CategoryInput categoryInput) {
        return ResponseEntity.ok(this.service.save(categoryInput));
    }

    @DeleteMapping(value = "{id}")
    public void delete(@PathVariable(value = "id") Long id) {
        this.service.delete(id);
    }
}
