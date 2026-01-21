package com.jon5307.blog.category;

import com.jon5307.blog.category.dto.CategoryResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/api/category")
@RequiredArgsConstructor
@RestController
public class CategoryController {

    private final CategoryService categoryService;

    @GetMapping("/list")
    public List<CategoryResponse> list() {
        return categoryService.getCategoryList();
    }

    @PostMapping("/create")
    public void createCategory(@RequestParam String name, @RequestParam String description) {
        categoryService.createCategory(name, description);
    }
}
