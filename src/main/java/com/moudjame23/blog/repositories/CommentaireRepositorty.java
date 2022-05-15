package com.moudjame23.blog.repositories;

import com.moudjame23.blog.entities.Commentaire;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CommentaireRepositorty extends JpaRepository<Commentaire, Integer> {
}
