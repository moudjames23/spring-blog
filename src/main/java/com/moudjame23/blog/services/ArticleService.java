package com.moudjame23.blog.services;

import com.moudjame23.blog.dto.ArticleDto;
import com.moudjame23.blog.entities.Article;
import com.moudjame23.blog.entities.Category;
import com.moudjame23.blog.exceptions.ResourceNotFoundException;
import com.moudjame23.blog.repositories.ArticleRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ArticleService {

    private final ArticleRepository articleRepository;



    public ArticleService(ArticleRepository articleRepository) {
        this.articleRepository = articleRepository;

    }

    public List<Article> getArticles()
    {
        return  this.articleRepository.findAll();
    }

    public Article create(Article article)
    {
        return this.articleRepository.save(article);
    }

    public Article show(int id)
    {
       return this.getArticleById(id);
    }

    public Article update(int id, Article article)
    {
        return this.articleRepository.save(article);

    }

    public void delete(int id)
    {
        this.articleRepository.delete(this.getArticleById(id));
    }

    public Article getArticleById(int id)
    {
        return this.articleRepository.findById(id).
                orElseThrow(() -> new ResourceNotFoundException("L'article avec un ID " + id+ " n'existe pas"));
    }

}
