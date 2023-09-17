package com.jatin.blog.com.jatin.blog.ServicesInterfaces;

import com.jatin.blog.com.jatin.blog.Payloads.PostDTO;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

public interface PostServiceInterface {

    PostDTO createPost(PostDTO postDTO,Long user_id , Long category_id);
    PostDTO updatePost(PostDTO postDTO);

    void deletePostById(Long post_id);
    PostDTO getPostById(Long post_id);

    List<PostDTO> getAllPosts(Integer pageSize, Integer pageNumber, String sortByProperty, String sortOrder , String keyword);

    List<PostDTO> getPostByCategory(Long category_id, Integer pageSize, Integer pageNumber, String sortByProperty, String sortOrder);

    List<PostDTO> getPostByUser(Long user_id,Integer pageSize, Integer pageNumber, String sortByProperty, String sortOrder);

}
