package com.jatin.blog.com.jatin.blog.Services;

import com.jatin.blog.com.jatin.blog.Entities.Category;
import com.jatin.blog.com.jatin.blog.Entities.Post;
import com.jatin.blog.com.jatin.blog.Entities.User;
import com.jatin.blog.com.jatin.blog.Exceptions.ResourceNotFoundException;
import com.jatin.blog.com.jatin.blog.Mapper.CategoryMapper;
import com.jatin.blog.com.jatin.blog.Mapper.PostMapper;
import com.jatin.blog.com.jatin.blog.Mapper.UserMapper;
import com.jatin.blog.com.jatin.blog.Payloads.CategoryDTO;
import com.jatin.blog.com.jatin.blog.Payloads.PostDTO;
import com.jatin.blog.com.jatin.blog.Payloads.UserDTO;
import com.jatin.blog.com.jatin.blog.Repositories.CategoryRepository;
import com.jatin.blog.com.jatin.blog.Repositories.PostRepository;
import com.jatin.blog.com.jatin.blog.Repositories.UserRepository;
import com.jatin.blog.com.jatin.blog.ServicesInterfaces.PostServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostService implements PostServiceInterface {


    @Autowired
    PostRepository postRepository;

    @Autowired
    CategoryRepository categoryRepository;

    @Autowired
    UserRepository userRepository;

    @Autowired
    UserService userService;

    @Autowired
    CategoryService categoryService;

    PostMapper postMapper;
    UserMapper userMapper;
    CategoryMapper categoryMapper;

    public PostService(PostMapper postMapper,UserMapper userMapper,CategoryMapper categoryMapper) {
        this.postMapper = postMapper;
        this.categoryMapper = categoryMapper;
        this.userMapper = userMapper;
    }


    public PostDTO createPost(PostDTO postDTO,Long user_id,Long category_id) {

        UserDTO userdto = userService.getUserById(user_id);
        User user = userMapper.toUserFromUserDTO(userdto);

        CategoryDTO categoryDTO = categoryService.getCategoryById(category_id);
        Category category = categoryMapper.toCategoryFromCategoryDTO(categoryDTO);

        Post post = postMapper.toPostFromPostDTO(postDTO);
        System.out.println(post.getTitle());
        post.setUser(user);
        post.setCategory(category);
        Post savedPost = postRepository.save(post);
        return postMapper.toPostDTOFromPost(savedPost);
    }

    @Override
    public PostDTO updatePost(PostDTO postDTO) {
        Post post = postMapper.toPostFromPostDTO(postDTO);
        Post savedPost = postRepository.save(post);
        return postMapper.toPostDTOFromPost(savedPost);
    }

    @Override
    public void deletePostById(Long post_id) {
        postRepository.deleteById(post_id);
    }

    @Override
    public PostDTO getPostById(Long post_id) {
        Post post = postRepository.findById(post_id).orElseThrow(() -> new ResourceNotFoundException("Post","id",post_id));

        return postMapper.toPostDTOFromPost(post);
    }


    @Override
    public List<PostDTO> getAllPosts() {
        List<Post> postList = postRepository.findAll();

        return postMapper.toPostDTOListFromPostList(postList);
    }

    @Override
    public List<PostDTO> getPostByCategory(Long category_id) {
        Category category = categoryRepository.findById(category_id).orElseThrow(()->new ResourceNotFoundException("Category","id",category_id));
        List<Post> postList = postRepository.getPostByCategory(category);
        return postMapper.toPostDTOListFromPostList(postList);
    }

    @Override
    public List<PostDTO> getPostByUser(Long user_id) {
        User user = userRepository.findById(user_id).orElseThrow(()->new ResourceNotFoundException("User","id",user_id));
        List<Post> postList = postRepository.getPostsByUser(user);
        return postMapper.toPostDTOListFromPostList(postList);
    }
}
