package com.jatin.blog.com.jatin.blog.Payloads;

import com.jatin.blog.com.jatin.blog.Entities.Category;
import com.jatin.blog.com.jatin.blog.Entities.User;
import jakarta.persistence.Column;
import jakarta.persistence.ManyToOne;
import lombok.Data;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
public class PostDTO {
    private Long id;

    private String Title;

    private String content;
    private String imageName;

    private Date addedDate;

    private CategoryDTO categoryDTO;

    private UserDTO userDTO;

//    private List<CommentDTO> commentsDTO = new ArrayList<CommentDTO>();

}
