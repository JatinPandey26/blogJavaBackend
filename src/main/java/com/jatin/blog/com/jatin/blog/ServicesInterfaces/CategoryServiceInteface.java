package com.jatin.blog.com.jatin.blog.ServicesInterfaces;

import com.jatin.blog.com.jatin.blog.Entities.Category;
import com.jatin.blog.com.jatin.blog.Exceptions.ResourceNotFoundException;
import com.jatin.blog.com.jatin.blog.Mapper.CategoryMapper;
import com.jatin.blog.com.jatin.blog.Payloads.CategoryDTO;

import java.util.List;

public interface CategoryServiceInteface {

    public CategoryDTO createCategory(CategoryDTO categoryDTO);

    public CategoryDTO updateCategory(CategoryDTO categoryDTO);

    public CategoryDTO getCategoryById(Long category_id);

    public List<CategoryDTO> getCategories();

    public void deleteCategoryById(Long category_id);
}
