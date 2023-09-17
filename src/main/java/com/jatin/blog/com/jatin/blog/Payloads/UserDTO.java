package com.jatin.blog.com.jatin.blog.Payloads;

import com.jatin.blog.com.jatin.blog.Entities.Post;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;


@Data
public class UserDTO {

    private long id;
    private String name;
    private String email;
    private String password;
    private String about;

}
