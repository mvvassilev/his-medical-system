package com.neuedu.hismedicalsystem.model.mapper;

import com.neuedu.hismedicalsystem.model.po.User;

import java.util.List;

public interface UserMapper {
    public List<User> getUsers();

    public void updateUser(User condition);
}
