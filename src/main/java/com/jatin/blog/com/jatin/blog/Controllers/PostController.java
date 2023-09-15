package com.jatin.blog.com.jatin.blog.Controllers;

import com.jatin.blog.com.jatin.blog.Payloads.PostDTO;
import com.jatin.blog.com.jatin.blog.Services.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/post")
public class PostController {

    @Autowired
    PostService postService;

    @PostMapping("/user/{user_id}/category/{category_id}/create")
    PostDTO create(@RequestBody PostDTO postDTO,@PathVariable Long user_id,@PathVariable Long category_id){
        System.out.println(postDTO);
        return postService.createPost(postDTO,user_id,category_id);
    }
    @PostMapping("/update")

    PostDTO update(@RequestBody PostDTO postDTO){
        return postService.updatePost(postDTO);
    }

    @DeleteMapping("/deleteById")
    void deleteById(@RequestParam Long post_id){
        postService.deletePostById(post_id);
    }


@GetMapping("/getById")
    PostDTO getPostById(@RequestParam Long post_id){
        return postService.getPostById(post_id);
    }

    @GetMapping("getAll")
    List<PostDTO> getAllPosts(){
        return postService.getAllPosts();
    }

    @GetMapping("/getByCategory")
    List<PostDTO> getPostByCategory(@RequestParam Long category_id){
        return  postService.getPostByCategory(category_id);
    }

    @GetMapping("/getByUser")
    List<PostDTO> getPostByUser(@RequestParam Long user_id){
        return postService.getPostByUser(user_id);
    }
}
