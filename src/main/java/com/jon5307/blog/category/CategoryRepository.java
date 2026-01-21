package com.jon5307.blog.category;

import com.jon5307.blog.category.dto.CategoryResponse;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CategoryRepository extends JpaRepository<Category,Long> {
    List<CategoryResponse> findAllBy();
}
