package com.jatin.blog.com.jatin.blog.Mapper;

import com.jatin.blog.com.jatin.blog.Entities.Category;
import com.jatin.blog.com.jatin.blog.Payloads.CategoryDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CategoryMapper {


    Category toCategoryFromCategoryDTO(CategoryDTO categoryDTO);

    CategoryDTO toCategoryDTOFromCategory(Category category);

    List<Category> toCategoryListFromCategoryDTOList(List<CategoryDTO> categoryDTOList);
    List<CategoryDTO> toCategoryDTOListFromCategoryList(List<Category> categoryList);

}
