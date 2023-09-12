package com.jatin.blog.com.jatin.blog.Controllers;

import com.jatin.blog.com.jatin.blog.Payloads.UserDTO;
import com.jatin.blog.com.jatin.blog.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping("/getUserById")
    UserDTO getUserById(@RequestParam long userId){
        return userService.getUserById(userId);
    }

    @GetMapping("/getAllUsers")
    List<UserDTO> getAllUsers(){
        return userService.getAllUsers();
    }

    @PostMapping("/createUser")
    UserDTO createUser(@RequestBody UserDTO userDTO){
        return userService.createUser(userDTO);
    }

    @DeleteMapping("/deleteUserById")
    void deleteUserById(@RequestParam long userId){
        userService.deleteUser(userId);
    }

}
