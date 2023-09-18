package com.jatin.blog.com.jatin.blog.Controllers;

import com.jatin.blog.com.jatin.blog.Config.AppConstants;
import com.jatin.blog.com.jatin.blog.Payloads.ApiResponse;
import com.jatin.blog.com.jatin.blog.Payloads.FileResponse;
import com.jatin.blog.com.jatin.blog.Payloads.PostDTO;
import com.jatin.blog.com.jatin.blog.Payloads.PostResponse;
import com.jatin.blog.com.jatin.blog.Services.FileService;
import com.jatin.blog.com.jatin.blog.Services.PostService;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StreamUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

@RestController
@RequestMapping("/api/post")
public class PostController {

    @Autowired
    private PostService postService;

    @Autowired
    private FileService fileService;

    @Value("${project.image}")
    private String filePath;

    @PostMapping("/user/{user_id}/category/{category_id}/create")
    ResponseEntity<PostDTO> create(@RequestBody PostDTO postDTO, @PathVariable Long user_id, @PathVariable Long category_id){
        System.out.println(postDTO);
        return new ResponseEntity<>(postService.createPost(postDTO,user_id,category_id), HttpStatus.CREATED);
    }
    @PutMapping("/update")
    ResponseEntity<PostDTO> update(@RequestBody PostDTO postDTO){
        return  new ResponseEntity<>(postService.updatePost(postDTO),HttpStatus.OK);
    }

    @DeleteMapping("/deleteById")
    ResponseEntity<ApiResponse> deleteById(@RequestParam Long post_id){
        postService.deletePostById(post_id);
        return new ResponseEntity<ApiResponse>(new ApiResponse("Post deleted successfully",true),HttpStatus.OK);
    }


    @GetMapping("/getById")
    ResponseEntity<PostDTO> getPostById(@RequestParam Long post_id){
        return new ResponseEntity<>(postService.getPostById(post_id),HttpStatus.OK) ;
    }

    @GetMapping("getAll")
    ResponseEntity<PostResponse> getAllPosts(@RequestParam(value = "pageSize" , defaultValue = AppConstants.PAGE_SIZE, required = false) Integer pageSize,
                                              @RequestParam(value = "pageNumber" , defaultValue = AppConstants.PAGE_NUMBER, required = false) Integer pageNumber,
                                              @RequestParam(value = "sortByProperty" , defaultValue = AppConstants.SORT_BY_PROPERTY , required = false) String sortByProperty,
                                              @RequestParam(value = "sortOrder" , defaultValue = AppConstants.SORT_ORDER , required = false) String sortOrder,
                                              @RequestParam(value = "keyword" , defaultValue = "" , required = false) String keyword
    ){
        List<PostDTO> postDTOList = postService.getAllPosts(pageSize,pageNumber,sortByProperty,sortOrder,keyword);
        return new ResponseEntity<PostResponse>(new PostResponse(postDTOList,pageSize,pageNumber,sortByProperty,sortOrder),HttpStatus.OK);
    }

    @GetMapping("/getByCategory")
    ResponseEntity<List<PostDTO>> getPostByCategory(@RequestParam Long category_id,
                                                    @RequestParam(value = "pageSize" , defaultValue = AppConstants.PAGE_SIZE, required = false) Integer pageSize,
                                                    @RequestParam(value = "pageNumber" , defaultValue = AppConstants.PAGE_NUMBER, required = false) Integer pageNumber,
                                                    @RequestParam(value = "sortByProperty" , defaultValue = AppConstants.SORT_BY_PROPERTY , required = false) String sortByProperty,
                                                    @RequestParam(value = "sortOrder" , defaultValue = AppConstants.SORT_ORDER , required = false) String sortOrder){
        return  new ResponseEntity<>(postService.getPostByCategory(category_id,pageSize,pageNumber,sortByProperty,sortOrder),HttpStatus.OK);
    }

    @GetMapping("/getByUser")
    ResponseEntity<List<PostDTO>> getPostByUser(@RequestParam Long user_id,
                                                @RequestParam(value = "pageSize" , defaultValue = AppConstants.PAGE_SIZE, required = false) Integer pageSize,
                                                @RequestParam(value = "pageNumber" , defaultValue = AppConstants.PAGE_NUMBER, required = false) Integer pageNumber,
                                                @RequestParam(value = "sortByProperty" , defaultValue = AppConstants.SORT_BY_PROPERTY , required = false) String sortByProperty,
                                                @RequestParam(value = "sortOrder" , defaultValue = AppConstants.SORT_ORDER , required = false) String sortOrder){
        return new ResponseEntity<>(postService.getPostByUser(user_id,pageSize,pageNumber,sortByProperty,sortOrder),HttpStatus.OK);
    }


    // upload image

    @PostMapping("/image/upload")
    ResponseEntity<PostDTO> uploadImage( @RequestBody MultipartFile image , @RequestParam Long post_id) throws IOException {
        PostDTO postDTO = postService.getPostById(post_id);
        String fileName = fileService.uploadImage(filePath,image);
        postDTO.setImageName(fileName);
        postService.updatePost(postDTO);
        return new ResponseEntity<>(postDTO,HttpStatus.OK);
    }

    @GetMapping(value = "/image",produces = MediaType.IMAGE_JPEG_VALUE)
    public void downloadImage(@RequestParam String fileName , HttpServletResponse response) throws IOException {
        InputStream resource = fileService.getResource(filePath,fileName);
        response.setContentType(MediaType.IMAGE_JPEG_VALUE);
        StreamUtils.copy(resource,response.getOutputStream());
    }


}
