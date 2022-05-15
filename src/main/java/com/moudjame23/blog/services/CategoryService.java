package com.moudjame23.blog.services;

import com.moudjame23.blog.entities.Article;
import com.moudjame23.blog.entities.Category;
import com.moudjame23.blog.exceptions.ResourceNotFoundException;
import com.moudjame23.blog.repositories.CategoryRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryService {

    private final CategoryRepository categoryRepository;

    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    public List<Category> getCategories()
    {
        return this.categoryRepository.findAll();
    }

    public Category create(Category category)
    {
        return this.categoryRepository.save(category);
    }

    public Category show(int id)
    {
        return this.getCategorie(id);
    }

    public Category update(Category category)
    {
        return this.categoryRepository.save(category);
    }

    public void delete(Category category)
    {
        this.categoryRepository.delete(category);
    }

    public Category getCategorie(int id)
    {
        return this.categoryRepository.findById(id).
                orElseThrow(() -> new ResourceNotFoundException("La categorie avec un ID " + id+ " n'existe pas"));
    }
}
