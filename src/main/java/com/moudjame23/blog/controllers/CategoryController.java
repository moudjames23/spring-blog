package com.moudjame23.blog.controllers;

import com.moudjame23.blog.dto.CategoryDto;
import com.moudjame23.blog.entities.Category;
import com.moudjame23.blog.services.CategoryService;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("api/v1")
public class CategoryController {

    private final CategoryService categoryService;


    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping("/categories")
    public ResponseEntity<List<Category>> index()
    {
        List<Category> categories = this.categoryService.getCategories();
        return ResponseEntity.ok(categories);
    }

    @PostMapping("/categories")
    public ResponseEntity<Category> create(@Valid @RequestBody CategoryDto categoryRequest, ModelMapper modelMapper)
    {
        Category category = categoryService.create(modelMapper.map(categoryRequest, Category.class));

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(category);
    }

    @GetMapping("/categories/{id}")
    public Category show(@PathVariable int id)
    {
        return categoryService.show(id);
    }

    @DeleteMapping("/categories/{id}")
    public String delete(@PathVariable int id)
    {
        this.categoryService.delete(this.getCategory(id));

        return "Success";
    }

    private Category getCategory(int id)
    {
        return this.categoryService.show(id);
    }

}
