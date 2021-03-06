package com.neuedu.hismedicalsystem.model.mapper;

import com.neuedu.hismedicalsystem.model.po.User;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface UserMapper {
    public List<User> getUsers(User condition);

    public void updateUser(User condition);

    public void updateUserInUserRDept(@Param("userid") int userid, @Param("list") List<String> deptList);

    public void deleteUserRDept(@Param("userid") int userid, @Param("deptcode") String deptcode);
    public void insertUserRDept(@Param("userid") int userid, @Param("deptcode") String deptcode);

    public void deleteUser(String userid);

    public void deleteUserFromUserRDept(String userid);

    public void addUser(User user);

    public void addUserToUserRDept(@Param("userid") int userid, @Param("list") List<String> deptList);

    int checkUserName(String username);

    int checkLogin(@Param("username") String username, @Param("password") String password);

    User getUserid(@Param("username") String username, @Param("password") String password);


    @Select("select * from user where username=#{username} and pwd=#{password}")
    public User loginGetUser(@Param("username") String name,@Param("password") String pw);
}
