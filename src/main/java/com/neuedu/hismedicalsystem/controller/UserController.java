package com.neuedu.hismedicalsystem.controller;

import com.neuedu.hismedicalsystem.model.po.User;
import com.neuedu.hismedicalsystem.model.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.sql.Date;
import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService UserService;

    @RequestMapping("/users")
    public List<User> getUsers(@RequestBody User condition){
        return userService.getUsers(condition);
    }
}
