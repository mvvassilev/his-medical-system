package com.neuedu.hismedicalsystem.model.service;


import com.neuedu.hismedicalsystem.model.mapper.UserMapper;
import com.neuedu.hismedicalsystem.model.po.User;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class UserService {
    @Resource
    private UserMapper userMapper;

    public void test(){
        System.out.println(userMapper);
    }

    public List<User> getUsers(User condition){
        return userMapper.getUsers(condition);
    }
}