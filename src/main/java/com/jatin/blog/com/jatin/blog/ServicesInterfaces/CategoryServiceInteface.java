package com.jatin.blog.com.jatin.blog.ServicesInterfaces;

import com.jatin.blog.com.jatin.blog.Entities.Category;
import com.jatin.blog.com.jatin.blog.Exceptions.ResourceNotFoundException;
import com.jatin.blog.com.jatin.blog.Mapper.CategoryMapper;
import com.jatin.blog.com.jatin.blog.Payloads.CategoryDTO;

import java.util.List;

public interface CategoryServiceInteface {

     CategoryDTO createCategory(CategoryDTO categoryDTO);

     CategoryDTO updateCategory(CategoryDTO categoryDTO);

     CategoryDTO getCategoryById(Long category_id);

     List<CategoryDTO> getCategories();

     void deleteCategoryById(Long category_id);
}
