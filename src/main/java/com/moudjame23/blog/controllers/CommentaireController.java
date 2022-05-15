package com.moudjame23.blog.controllers;

import com.moudjame23.blog.dto.CommentaireDto;
import com.moudjame23.blog.entities.Article;
import com.moudjame23.blog.entities.Commentaire;
import com.moudjame23.blog.services.ArticleService;
import com.moudjame23.blog.services.CommentaireService;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("api/v1")
public class CommentaireController {

    private CommentaireService commentaireService;
    private ArticleService articleService;

    public CommentaireController(CommentaireService commentaireService, ArticleService articleService) {
        this.commentaireService = commentaireService;
        this.articleService = articleService;
    }

    @GetMapping("/{articleId}/commentaires")
    public List<Commentaire> index(@PathVariable("articleId") int articleId)
    {
        Article article = articleService.getArticleById(articleId);

        return article.getCommentaires();
    }

    @PostMapping("/{articleId}/commentaires")
    public Commentaire create(@PathVariable("articleId") int articleId, @RequestBody @Valid CommentaireDto commentaireDto)
    {
        Article article = articleService.getArticleById(articleId);

        Commentaire commentaire = Commentaire.builder()
                .auteur(commentaireDto.getAuteur())
                .article(article)
                .contenu(commentaireDto.getContenu())
                .build();

        return  commentaireService.create(commentaire);
    }
}
