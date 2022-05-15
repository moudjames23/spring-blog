package com.moudjame23.blog;

import com.moudjame23.blog.dto.ArticleDto;
import com.moudjame23.blog.entities.Article;
import com.moudjame23.blog.entities.Category;
import com.moudjame23.blog.services.ArticleService;
import com.moudjame23.blog.services.CategoryService;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.LinkedList;
import java.util.List;

@SpringBootApplication
public class BlogApplication {

    public static void main(String[] args) {
        SpringApplication.run(BlogApplication.class, args);
    }

    private final static Logger log = LoggerFactory.getLogger(BlogApplication.class);

    @Bean
    public ModelMapper modelMapper()
    {
        return  new ModelMapper();
    }

    @Bean
    public CommandLineRunner seeders(final CategoryService categoryService, ArticleService articleService, ModelMapper modelMapper) {
        return new CommandLineRunner() {
            @Override
            public void run(String... args) throws Exception {
                List<Category> categories = new LinkedList<>();

                log.info("------ Initialisation des seeders -------");

                Category categoryPolitique = Category.builder()
                        .name("Poliques")
                        .build();
                Category categoryReligion = Category.builder()
                        .name("Religion")
                        .build();

                Category categoryTechnologie = Category.builder()
                        .name("Technologie")
                        .build();

                List.of(categoryPolitique, categoryReligion, categoryTechnologie).stream()
                        .forEach(category -> {
                            categoryService.create(category);
                        });

                Article article1 = Article.builder()
                        .title("Spring boot")
                        .content("Meilleur framework web Java")
                        .category(categoryTechnologie)
                        .build();

                Article article2 = Article.builder()
                        .title("Laravel")
                        .content("Meilleur framework web PHP")
                        .category(categoryTechnologie)
                        .build();

               /* List.of(article1, article2).stream()
                                .forEach(article -> {
                                    System.out.println(article.toString());


                                    articleService.create(article);
                                });*/

                articleService.getArticles().stream()
                        .forEach(article -> {
                            System.out.println("Article: " +article.toString());
                        });



            }
        };
    }
}
