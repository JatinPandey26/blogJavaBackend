package com.jatin.blog.com.jatin.blog.Entities;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.CurrentTimestamp;

import java.util.Date;

@Entity
@Data
@Table
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false,length = 100)
    private String Title;

    @Column(length = 1000)
    private String content;

    @Column
    private String imageName;

    @CurrentTimestamp
    @Column
    private Date addedDate;

    @ManyToOne
    private User user;

    @ManyToOne
    private Category category;


}

