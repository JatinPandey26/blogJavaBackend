package com.jatin.blog.com.jatin.blog.Mapper;

import com.jatin.blog.com.jatin.blog.Config.CycleAvoidingMappingContext;
import com.jatin.blog.com.jatin.blog.Entities.Comment;
import com.jatin.blog.com.jatin.blog.Payloads.CommentDTO;
import org.mapstruct.Context;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring",uses = {PostMapper.class,UserMapper.class})
public interface CommentMapper {


//    @Mapping(target = "post")
    List<Comment> toCommentListFromCommentDTOList(List<CommentDTO> commentDTOList);

    List<CommentDTO> toCommentDTOListFromCommentList(List<Comment> commentList);

    @Mapping(target = "user", source = "userDTO")
    @Mapping(target = "post", source = "postDTO")
    Comment toCommentFromCommentDTO(CommentDTO commentDTO);

    @Mapping(target = "userDTO", source = "user")
    @Mapping(target = "postDTO", source = "post")
    CommentDTO toCommentDTOFromComment(Comment comment);

}
