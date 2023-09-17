package com.jatin.blog.com.jatin.blog.Entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.CurrentTimestamp;

import java.util.Date;

@Entity
@Data
@Table(name = "comments")
public class Comment {
    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @CurrentTimestamp
    @Column
    private Date date;

    @Column
    private String content;


    @ManyToOne()
    private Post post;

    @ManyToOne
    private User user;

}
