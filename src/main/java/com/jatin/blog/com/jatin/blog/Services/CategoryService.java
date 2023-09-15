package com.jatin.blog.com.jatin.blog.Services;

import com.jatin.blog.com.jatin.blog.Entities.Category;
import com.jatin.blog.com.jatin.blog.Exceptions.ResourceNotFoundException;
import com.jatin.blog.com.jatin.blog.Mapper.CategoryMapper;
import com.jatin.blog.com.jatin.blog.Payloads.CategoryDTO;
import com.jatin.blog.com.jatin.blog.Repositories.CategoryRepository;
import com.jatin.blog.com.jatin.blog.ServicesInterfaces.CategoryServiceInteface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService implements CategoryServiceInteface{

    @Autowired
    CategoryRepository categoryRepository;
    CategoryMapper categoryMapper;

    public CategoryService(CategoryMapper categoryMapper) {

        this.categoryMapper = categoryMapper;
    }

    public CategoryDTO createCategory(CategoryDTO categoryDTO){

            Category category = categoryMapper.toCategoryFromCategoryDTO(categoryDTO);
            Category savedCategory =  categoryRepository.save(category);
            return categoryMapper.toCategoryDTOFromCategory(savedCategory);
    }

    public CategoryDTO updateCategory(CategoryDTO categoryDTO){
        Category category = categoryMapper.toCategoryFromCategoryDTO(categoryDTO);
        Category updatedCategory =  categoryRepository.save(category);
        return categoryMapper.toCategoryDTOFromCategory(updatedCategory);
    }

    public CategoryDTO getCategoryById(Long category_id){
            Category category = categoryRepository.findById(category_id).orElseThrow(() -> new ResourceNotFoundException("Category","id",category_id));

            return categoryMapper.toCategoryDTOFromCategory(category);
    }

    public List<CategoryDTO> getCategories(){
        List<Category> categoryList = categoryRepository.findAll();
        return categoryMapper.toCategoryDTOListFromCategoryList(categoryList);
    }

    public void deleteCategoryById(Long category_id){
        categoryRepository.deleteById(category_id);
    }

}
