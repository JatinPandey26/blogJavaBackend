package com.jatin.blog.com.jatin.blog.Payloads;


import lombok.Data;

import java.util.Date;

@Data
public class CommentDTO {
    private Long id;
    private Date date;
    private String content;
    private PostDTO postDTO;
    private UserDTO userDTO;
}
