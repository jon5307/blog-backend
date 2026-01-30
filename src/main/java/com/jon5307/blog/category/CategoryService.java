package com.jon5307.blog.category;

import com.jon5307.blog.category.dto.CategoryCreateRequest;
import com.jon5307.blog.category.dto.CategoryResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class CategoryService {
    private final CategoryRepository categoryRepository;

    public List<CategoryResponse> getCategoryList() {
        return categoryRepository.findAllBy();
    }

    public void createCategory(CategoryCreateRequest request) {
        Category category = new Category();
        category.setName(request.name());
        category.setDescription(request.description());
        categoryRepository.save(category);
    }

    public CategoryResponse getCategory(Long id) {
        Optional<Category> category = categoryRepository.findById(id);
        if (category.isPresent()) {
            return CategoryResponse.from(category.get());
        } else {
            throw new RuntimeException("Category not found");
        }
    }
}
