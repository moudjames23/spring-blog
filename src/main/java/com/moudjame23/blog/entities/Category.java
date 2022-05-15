package com.moudjame23.blog.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity(name = "categories")
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String name;

    private boolean status = true;

    @OneToMany
    @JsonIgnore
    private List<Article> articles;

    public Category(String name) {
        this.name = name;
    }
}
