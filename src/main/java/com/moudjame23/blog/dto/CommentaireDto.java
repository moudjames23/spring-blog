package com.moudjame23.blog.dto;

import com.moudjame23.blog.entities.Article;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CommentaireDto {

    @NotBlank(message = "Le contenu du commentaire est obligatoire")
    @Length(
            min = 2,
            max = 255,
            message = "Le nombre de caracteres du titre doit etre compris entre 2 et 255")
    private String contenu;

    @NotBlank(message = "Le contenu du commentaire est obligatoire")
    @Length(
            min = 2,
            message = "Le nombre de caracteres du titre doit etre superieur a  2")
    private String auteur;

    @NotNull
    private int article_id;
}
