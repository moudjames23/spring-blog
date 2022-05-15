package com.moudjame23.blog.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;
import org.springframework.lang.NonNull;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ArticleDto {


    @NotBlank( message = "Le titre de l'article est obligatoire")
    @Length(
            min = 5,
            max = 100,
            message = "Le nombre de caracteres du titre doit etre compris entre 5 et 100")
    private String title;

    @NotBlank
    @Length(
            min = 5,
            message = "Le nombre de caracteres du contenu doit etre superieur à 5")
    private String content;


    private int category_id;
}
