package com.jatin.blog.com.jatin.blog.Services;

import com.jatin.blog.com.jatin.blog.Entities.User;
import com.jatin.blog.com.jatin.blog.Exceptions.ResourceNotFoundException;
import com.jatin.blog.com.jatin.blog.Mapper.UserMapper;
import com.jatin.blog.com.jatin.blog.Payloads.UserDTO;
import com.jatin.blog.com.jatin.blog.Repositories.UserRepository;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    UserMapper userMapper;

    public UserService(UserMapper userMapper) {
        this.userMapper = userMapper;
    }


    public UserDTO createUser(UserDTO userdto){

        User savedUser = userRepository.save(userMapper.toUserFromUserDTO(userdto));
        return userMapper.toUserDTOfromUser(savedUser) ;

    }
    public UserDTO updateUser(UserDTO userdto,long userId){
        User user = userMapper.toUserFromUserDTO(userdto);
        User savedUser = this.userRepository.save(user);
        return userMapper.toUserDTOfromUser(savedUser);
    }
    public UserDTO getUserById(long userId){

        User user = userRepository.findById(userId).orElseThrow(() ->  new ResourceNotFoundException("User","id",userId));

        return userMapper.toUserDTOfromUser(user);
    }
    public List<UserDTO> getAllUsers(){
        List<User> users = userRepository.findAll();
        return userMapper.toUserDTOListFromUserList(users);
    }
    public void deleteUser(long userId){
        this.userRepository.deleteById(userId);
    }

}
