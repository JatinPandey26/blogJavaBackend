package com.jatin.blog.com.jatin.blog.Payloads;

import com.jatin.blog.com.jatin.blog.Entities.Post;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class CategoryDTO {
    private long id;
    private String title;
    private String description;
}
