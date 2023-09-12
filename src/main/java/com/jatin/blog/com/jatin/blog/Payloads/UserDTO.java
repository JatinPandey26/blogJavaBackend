package com.jatin.blog.com.jatin.blog.Payloads;


import lombok.Data;
import lombok.NoArgsConstructor;

@Data
public class UserDTO {

    private long id;
    private String name;
    private String email;
    private String password;
    private String about;
}
