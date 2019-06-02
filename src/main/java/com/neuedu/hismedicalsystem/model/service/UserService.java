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

    public List<User> getUsers(User condition){
        return userMapper.getUsers(condition);
    }

    @Transactional
    public void updateUser(User condition, List<String> deptList){
        //update user
        userMapper.updateUser(condition);
        //delete relevant depts
        String userid = String.valueOf(condition.getUserid());
        userMapper.deleteUserFromUserRDept(userid);
        //append new depts
        userMapper.addUserToUserRDept(condition.getUserid(), deptList);
    }

    @Transactional
    public void deleteUser(String userid) {
        userMapper.deleteUser(userid);
        userMapper.deleteUserFromUserRDept(userid);
    }

    @Transactional
    public void addUser(User user, List<String> deptList) {
        userMapper.addUser(user);
        userMapper.addUserToUserRDept(user.getUserid(), deptList);
    }

    public int checkUserName(String username) {
        return userMapper.checkUserName(username);
    }

    public int checkLogin(String username, String password) { return userMapper.checkLogin(username, password);
    }
}