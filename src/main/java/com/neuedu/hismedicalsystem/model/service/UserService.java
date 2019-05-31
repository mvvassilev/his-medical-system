package com.neuedu.hismedicalsystem.model.service;


import com.neuedu.hismedicalsystem.model.mapper.UserMapper;
import com.neuedu.hismedicalsystem.model.po.Dept;
import com.neuedu.hismedicalsystem.model.po.User;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Service
public class UserService {
    @Resource
    private UserMapper userMapper;

    public void test(){
        System.out.println(userMapper);
    }

    public List<User> getUsers(){
        return userMapper.getUsers();
    }

    @Transactional
    public void updateUser(User condition){ userMapper.updateUser(condition);}

    @Transactional
    public void deleteUser(String userid) {
        userMapper.deleteUser(userid);
        userMapper.deleteUserFromUserRDept(userid);
    }

    @Transactional
    public void addUser(User user) {
        userMapper.addUser(user);
        List<Dept> list = user.getDepts();
        userMapper.addUserToUserRDept(user.getUserid(), list);
    }
}