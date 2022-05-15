package com.moudjame23.blog.controllers;

import com.moudjame23.blog.dto.ArticleDto;
import com.moudjame23.blog.entities.Article;
import com.moudjame23.blog.entities.Category;
import com.moudjame23.blog.exceptions.ResourceNotFoundException;
import com.moudjame23.blog.repositories.CategoryRepository;
import com.moudjame23.blog.services.ArticleService;
import com.moudjame23.blog.services.CategoryService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("api/v1")
public class ArticleController {

    private ArticleService articleService;
    private CategoryService categoryService;

    public ArticleController(ArticleService articleService, CategoryService categoryService) {
        this.articleService = articleService;
        this.categoryService = categoryService;
    }



    @GetMapping("/articles")
    public List<Article> index()
    {
        return  this.articleService.getArticles();
    }

    @PostMapping("/articles")
    public Article create(@RequestBody @Valid ArticleDto articleDto)
    {
        Category category = this.categoryService.getCategorie(articleDto.getCategory_id());
        Article article = Article.builder()
                .title(articleDto.getTitle())
                .content(articleDto.getContent())
                .category(category)
                .build();

        return this.articleService.create(article);
    }

    @GetMapping("/articles/{id}")
    public Article show(@PathVariable("id") int id)
    {
        return this.articleService.show(id);
    }

    @PutMapping("/articles/{id}")
    public Article update(@PathVariable("id") int id, @RequestBody @Valid ArticleDto articleDto, ModelMapper mapper)
    {
        Article article = articleService.getArticleById(id);

        Category category = this.categoryService.getCategorie(articleDto.getCategory_id());

        article.setContent(articleDto.getContent());
        article.setTitle(articleDto.getTitle());
        article.setCategory(category);

        return this.articleService.update(id, article);
    }

    @DeleteMapping("/articles/{id}")
    public void delete(@PathVariable("id") int id)
    {
        this.articleService.delete(id);
    }
}
