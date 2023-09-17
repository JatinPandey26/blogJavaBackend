package com.jatin.blog.com.jatin.blog.Mapper;

import com.jatin.blog.com.jatin.blog.Entities.User;
import com.jatin.blog.com.jatin.blog.Payloads.UserDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;


import java.util.List;


@Mapper(componentModel = "spring",unmappedTargetPolicy = ReportingPolicy.IGNORE,unmappedSourcePolicy = ReportingPolicy.IGNORE)
public interface UserMapper {

    UserDTO toUserDTOfromUser(User user);

    User toUserFromUserDTO(UserDTO userDTO);

    List<User> toUserListFromUserDTOList(List<UserDTO> userDTOList);
    List<UserDTO> toUserDTOListFromUserList(List<User> userList);
}
