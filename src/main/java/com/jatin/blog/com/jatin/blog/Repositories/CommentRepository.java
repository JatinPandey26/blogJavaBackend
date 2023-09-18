package com.jatin.blog.com.jatin.blog.Repositories;

import com.jatin.blog.com.jatin.blog.Entities.Comment;
import com.jatin.blog.com.jatin.blog.Entities.Post;
import com.jatin.blog.com.jatin.blog.Entities.User;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface CommentRepository extends JpaRepository<Comment,Long> {
    List<Comment> getCommentByUser(User user , Pageable pageable);
    List<Comment> getCommentByPost(Post post);

    @Query(value = "select * from comments Where date >= current_date - 7",nativeQuery = true)
    List<Comment> getCommentsOnlyContentFromPreviousWeek();
}
