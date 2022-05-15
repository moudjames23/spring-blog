package com.moudjame23.blog.services;

import com.moudjame23.blog.entities.Commentaire;
import com.moudjame23.blog.exceptions.ResourceNotFoundException;
import com.moudjame23.blog.repositories.CommentaireRepositorty;
import org.springframework.stereotype.Service;

@Service
public class CommentaireService {

    private CommentaireRepositorty commentaireRepositorty;

    public CommentaireService(CommentaireRepositorty commentaireRepositorty) {
        this.commentaireRepositorty = commentaireRepositorty;
    }

    public Commentaire create(Commentaire commentaire)
    {
        return this.commentaireRepositorty.save(commentaire);
    }

    public Commentaire show(int id)
    {
        return  getCommentaireById(id);
    }

    public Commentaire update(int id, Commentaire commentaire)
    {
        return commentaireRepositorty.save(commentaire);
    }


    public Commentaire getCommentaireById(int id)
    {
        return commentaireRepositorty.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Le commentaire avec " +id+ " n'existe pas"));
    }


}
