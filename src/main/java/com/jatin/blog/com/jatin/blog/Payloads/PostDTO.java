package com.jatin.blog.com.jatin.blog.Payloads;

import com.jatin.blog.com.jatin.blog.Entities.Category;
import com.jatin.blog.com.jatin.blog.Entities.User;
import jakarta.persistence.Column;
import jakarta.persistence.ManyToOne;
import lombok.Data;

import java.util.Date;

@Data
public class PostDTO {
    private Long id;

    private String Title;

    private String content;
    private String imageName;

    private Date addedDate;

}
