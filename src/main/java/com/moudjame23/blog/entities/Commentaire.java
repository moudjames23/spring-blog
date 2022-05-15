package com.moudjame23.blog.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "commentaires")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Commentaire {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private String contenu;

    private String auteur;

    @ManyToOne
    @JoinColumn(
            name = "article_id",
            referencedColumnName = "id"
    )
    @JsonIgnore
    private Article article;
}
