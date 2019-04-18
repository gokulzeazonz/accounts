package com.zeazonz.domain.model.category;

import java.util.Optional;

public interface CategoryRepository {
    Category addCategory(Category category);
    Optional<Category> getCategory(String name);
    Long getCategoryId(String name);
}
