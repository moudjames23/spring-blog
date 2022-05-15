package com.moudjame23.blog.repositories;

import com.moudjame23.blog.entities.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Integer> {

    //Category findById(int id);
}
