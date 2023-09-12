package com.jatin.blog.com.jatin.blog.Entities;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "user_name" , nullable = false,length = 100)
    private String name;

    @Column(unique = true)
    private String email;

    private String password;

    private String about;

}
