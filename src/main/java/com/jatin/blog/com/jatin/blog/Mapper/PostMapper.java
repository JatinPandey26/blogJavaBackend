package com.jatin.blog.com.jatin.blog.Mapper;

import com.jatin.blog.com.jatin.blog.Entities.Post;
import com.jatin.blog.com.jatin.blog.Payloads.PostDTO;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface PostMapper {
    Post toPostFromPostDTO(PostDTO postDTO);
    PostDTO toPostDTOFromPost(Post post);

    List<Post> toPostListFromPostDTOList(List<PostDTO> postDTOList);

    List<PostDTO> toPostDTOListFromPostList(List<Post> postList);
}
