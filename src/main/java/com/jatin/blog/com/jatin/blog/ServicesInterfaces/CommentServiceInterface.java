package com.jatin.blog.com.jatin.blog.ServicesInterfaces;

import com.jatin.blog.com.jatin.blog.Payloads.CommentDTO;

import java.util.List;

public interface CommentServiceInterface {
    CommentDTO createComment(CommentDTO commentDTO,Long post_id,Long user_id);
    void deleteComment(Long comment_id);

    List<CommentDTO> getAllComments();

    List<CommentDTO> getCommentsByPostID(Long post_id);
}
