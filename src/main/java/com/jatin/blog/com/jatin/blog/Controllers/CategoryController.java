package com.jatin.blog.com.jatin.blog.Controllers;

import com.jatin.blog.com.jatin.blog.Entities.Category;
import com.jatin.blog.com.jatin.blog.Payloads.ApiResponse;
import com.jatin.blog.com.jatin.blog.Payloads.CategoryDTO;
import com.jatin.blog.com.jatin.blog.Services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/category")
public class CategoryController {

    @Autowired
    CategoryService categoryService;
    @PostMapping("/create")
     public ResponseEntity<CategoryDTO> createCategory(@RequestBody CategoryDTO categoryDTO){
        CategoryDTO responseCategoryDTO = categoryService.createCategory(categoryDTO);
        return new ResponseEntity<>(responseCategoryDTO, HttpStatus.CREATED);
    }

    @PutMapping("/update")
    public ResponseEntity<CategoryDTO> updateCategory(@RequestBody CategoryDTO categoryDTO){
        CategoryDTO responseCategoryDTO = categoryService.createCategory(categoryDTO);
        return new ResponseEntity<>(responseCategoryDTO, HttpStatus.CREATED);
    }

    @DeleteMapping("/deleteById")
    public ResponseEntity<ApiResponse> deleteCategoryById(@RequestParam Long category_id){
        categoryService.deleteCategoryById(category_id);
        return new ResponseEntity<ApiResponse>(new ApiResponse(String.format("Category with categoryID : %d deleted successfully",category_id),true),HttpStatus.OK);
    }

    @GetMapping("/getCategoryById")
    public ResponseEntity<CategoryDTO> getCategoryByID(@RequestParam Long category_id){
        CategoryDTO categoryDTO = categoryService.getCategoryById(category_id);
        System.out.println(category_id);
        return new ResponseEntity<>(categoryDTO,HttpStatus.FOUND);
    }

    @GetMapping("/getAllCategories")
    public ResponseEntity<List<CategoryDTO>> getAllCategories(){
        List<CategoryDTO> categoryDTOList = categoryService.getCategories();
        return new ResponseEntity<>(categoryDTOList,HttpStatus.FOUND);
    }





}
