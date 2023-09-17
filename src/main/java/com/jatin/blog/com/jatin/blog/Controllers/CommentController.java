package com.jatin.blog.com.jatin.blog.Controllers;

import com.jatin.blog.com.jatin.blog.Payloads.ApiResponse;
import com.jatin.blog.com.jatin.blog.Payloads.CommentDTO;
import com.jatin.blog.com.jatin.blog.Services.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/comment")
public class CommentController {

    @Autowired
    CommentService commentService;

    @PostMapping("/create")
    public ResponseEntity<CommentDTO> createComment(@RequestBody CommentDTO commentDTO, @RequestParam Long post_id , @RequestParam Long user_id){
        CommentDTO savedCommentDTO = this.commentService.createComment(commentDTO,post_id,user_id);
        return new ResponseEntity<>(savedCommentDTO, HttpStatus.CREATED);
    }

    @DeleteMapping("/")
    public ResponseEntity<ApiResponse> deleteComment(@RequestParam Long comment_id){
        this.commentService.deleteComment(comment_id);
        return new ResponseEntity<>(new ApiResponse("Comment delete successfully",true),HttpStatus.OK);
    }

    @GetMapping("/all")
    ResponseEntity<List<CommentDTO>> getAllComments(){
        List<CommentDTO> commentDTOS = this.commentService.getAllComments();
        return new ResponseEntity<>(commentDTOS,HttpStatus.OK);
    }

    @GetMapping("/post")
    ResponseEntity<List<CommentDTO>> getAllComments(@RequestParam Long post_id){
        List<CommentDTO> commentDTOS = this.commentService.getCommentsByPostID(post_id);
        return new ResponseEntity<>(commentDTOS,HttpStatus.OK);
    }
}
