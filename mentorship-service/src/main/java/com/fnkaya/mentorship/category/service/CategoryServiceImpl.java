package com.fnkaya.mentorship.category.service;

import com.fnkaya.mentorship.category.domain.Category;
import com.fnkaya.mentorship.category.domain.Category.Fields;
import com.fnkaya.mentorship.category.model.CategoryDto;
import com.fnkaya.mentorship.category.model.CategoryInput;
import com.fnkaya.mentorship.category.model.mapper.CategoryMapper;
import com.fnkaya.mentorship.category.repository.CategoryRepository;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository repository;
    private final CategoryMapper mapper;

    @Override
    public CategoryDto save(CategoryInput categoryInput) {
        Optional<Category> categoryOptional = repository.findByNameIgnoreCase(categoryInput.getName());

        if (categoryOptional.isPresent()) {
            throw new IllegalArgumentException(categoryOptional.get().getName() + " isminde katerogi zaten var.");
        }

        if (categoryInput.getParent() != null) {
            boolean parentExists = this.repository.existsById(categoryInput.getParent().getId());
            if (!parentExists) {
                throw new IllegalArgumentException(categoryInput.getParent().getName() + " değerine sahip bir kategori bulunamadı.");
            }
        }

        return mapper.toDto(this.repository.save(mapper.toEntity(categoryInput)));
    }

    @Override
    public CategoryDto getById(Long id) {
        return repository.findById(id).map(mapper::toDto)
            .orElseThrow(() -> new IllegalArgumentException(id + " id değerine ait bir kategori bulunamadı."));
    }

    @Override
    public List<CategoryDto> getAll() {
        return repository.findAll(Sort.by(Fields.name)).stream().map(mapper::toDto).collect(Collectors.toList());
    }

    @Override
    public void delete(Long id) {
        if (!this.repository.existsById(id)) {
            throw new IllegalArgumentException(id + " id değerine ait bir kategori bulunamadı.");
        }
        repository.deleteById(id);
    }
}
