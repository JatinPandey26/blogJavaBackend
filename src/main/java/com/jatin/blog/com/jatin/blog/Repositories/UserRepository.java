package com.jatin.blog.com.jatin.blog.Repositories;

import com.jatin.blog.com.jatin.blog.Entities.User;
import com.jatin.blog.com.jatin.blog.Payloads.UserDTO;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface UserRepository extends JpaRepository<User,Long> {
}
