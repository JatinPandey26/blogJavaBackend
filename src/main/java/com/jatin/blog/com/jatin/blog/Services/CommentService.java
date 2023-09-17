package com.jatin.blog.com.jatin.blog.Services;

import com.jatin.blog.com.jatin.blog.Entities.Comment;
import com.jatin.blog.com.jatin.blog.Entities.Post;
import com.jatin.blog.com.jatin.blog.Exceptions.ResourceNotFoundException;
import com.jatin.blog.com.jatin.blog.Mapper.CommentMapper;
import com.jatin.blog.com.jatin.blog.Mapper.PostMapper;
import com.jatin.blog.com.jatin.blog.Mapper.UserMapper;
import com.jatin.blog.com.jatin.blog.Payloads.CommentDTO;
import com.jatin.blog.com.jatin.blog.Payloads.PostDTO;
import com.jatin.blog.com.jatin.blog.Payloads.UserDTO;
import com.jatin.blog.com.jatin.blog.Repositories.CommentRepository;
import com.jatin.blog.com.jatin.blog.Repositories.PostRepository;
import com.jatin.blog.com.jatin.blog.Repositories.UserRepository;
import com.jatin.blog.com.jatin.blog.ServicesInterfaces.CommentServiceInterface;
import org.mapstruct.Context;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentService implements CommentServiceInterface {

    @Autowired
    private CommentRepository commentRepository;
    @Autowired
    private PostRepository postRepository;

    @Autowired
    private PostService postService;

    @Autowired
    private UserService userService;

    private final CommentMapper commentMapper;
    private final PostMapper postMapper;
    private final UserMapper userMapper;

    public CommentService(CommentMapper commentMapper, PostMapper postMapper, UserMapper userMapper) {
        this.commentMapper = commentMapper;
        this.postMapper = postMapper;
        this.userMapper = userMapper;
    }


    @Override
    public CommentDTO createComment(CommentDTO commentDTO, Long post_id, Long user_id) {

        PostDTO postDTO = postService.getPostById(post_id);
        UserDTO userDTO = userService.getUserById(user_id);

        Comment comment = this.commentMapper.toCommentFromCommentDTO(commentDTO);
        System.out.println(postMapper.toPostFromPostDTO(postDTO));
        comment.setPost(postMapper.toPostFromPostDTO(postDTO));
        comment.setUser(userMapper.toUserFromUserDTO(userDTO));
        Comment savedComment = commentRepository.save(comment);
        System.out.println(savedComment);
        return commentMapper.toCommentDTOFromComment(savedComment);
    }

    @Override
    public void deleteComment(Long comment_id) {
        Comment comment = commentRepository.findById(comment_id).orElseThrow(() -> new ResourceNotFoundException("Comment","id",comment_id));
        commentRepository.delete(comment);
    }

    @Override
    public List<CommentDTO> getAllComments() {
        List<Comment> comments = this.commentRepository.findAll();

        return this.commentMapper.toCommentDTOListFromCommentList(comments) ;
    }

    @Override
    public List<CommentDTO> getCommentsByPostID(Long post_id) {
        Post post = this.postRepository.findById(post_id).orElseThrow(() -> new ResourceNotFoundException("Post","id",post_id));

        List<Comment> comments = this.commentRepository.getCommentByPost(post);
        return this.commentMapper.toCommentDTOListFromCommentList(comments);
    }
}
