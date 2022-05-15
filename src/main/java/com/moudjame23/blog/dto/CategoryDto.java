package com.moudjame23.blog.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CategoryDto {

    @NotBlank(message = "Le nom de la categorie est obligatoire")
    @Length(min = 3, max = 50, message = "Le nombre de caracteres doit etre compris entre 3 et 50")
    private String name;
}
