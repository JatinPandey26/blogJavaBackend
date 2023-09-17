package com.jatin.blog.com.jatin.blog.Mapper;

import com.jatin.blog.com.jatin.blog.Entities.Post;
import com.jatin.blog.com.jatin.blog.Payloads.CategoryDTO;
import com.jatin.blog.com.jatin.blog.Payloads.PostDTO;
import com.jatin.blog.com.jatin.blog.Payloads.UserDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(componentModel = "spring",uses = {UserMapper.class,CategoryMapper.class,CommentMapper.class})
public interface PostMapper {

    @Mapping(target = "user", source = "userDTO")
    @Mapping(target = "category", source = "categoryDTO")
    Post toPostFromPostDTO(PostDTO postDTO);

    @Mapping(target = "categoryDTO", source = "category")
    @Mapping(target = "userDTO", source = "user")
    PostDTO toPostDTOFromPost(Post post);

    List<Post> toPostListFromPostDTOList(List<PostDTO> postDTOList);

    List<PostDTO> toPostDTOListFromPostList(List<Post> postList);
}
