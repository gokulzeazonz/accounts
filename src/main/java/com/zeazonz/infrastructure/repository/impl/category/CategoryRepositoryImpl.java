package com.zeazonz.infrastructure.repository.impl.category;

import com.zeazonz.domain.model.category.Category;
import com.zeazonz.domain.model.category.CategoryRepository;

import java.util.Optional;

public class CategoryRepositoryImpl implements CategoryRepository {

    @Override
    public Category addCategory(Category category) {
        return null;
    }

    @Override
    public Optional<Category> getCategory(String name) {
        return Optional.empty();
    }

    @Override
    public Long getCategoryId(String name) {
        return null;
    }
}
