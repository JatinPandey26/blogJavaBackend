package com.jatin.blog.com.jatin.blog.Repositories;

import com.jatin.blog.com.jatin.blog.Entities.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends JpaRepository<Category,Long> {

}
