package com.neuedu.hismedicalsystem.model.service;


import com.neuedu.hismedicalsystem.model.mapper.UserMapper;
import com.neuedu.hismedicalsystem.model.po.Dept;
import com.neuedu.hismedicalsystem.model.po.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {
    @Autowired
    RedisTemplate<String, String> redisTemplate;

    @Resource
    private UserMapper userMapper;

    public void test(){
        System.out.println(userMapper);
    }

    public List<User> getUsers(User condition){
        return userMapper.getUsers(condition);
    }

    @Transactional
    public void updateUser(User condition, List<String> newDeptCodeList){
        //Get original User with all its information (all depts included)
        User temp = new User();
        temp.setUserid(condition.getUserid());
        User user = getUsers(temp).get(0);
        //Get its original dept list
        List<Dept> oldDL = user.getDepts();
        List<String> oldDeptCodeList = new ArrayList<>();
        for(int i = 0; i < oldDL.size(); i++){
            oldDeptCodeList.add(oldDL.get(i).getDeptcode());
        }

        List<String> unchangedDeptCodeList = new ArrayList<>();
        unchangedDeptCodeList.addAll(newDeptCodeList);
        unchangedDeptCodeList.retainAll(oldDeptCodeList);//交集

        List<String> toBeDeletedList = new ArrayList<>();
        toBeDeletedList.addAll(oldDeptCodeList);
        toBeDeletedList.removeAll(unchangedDeptCodeList);

        List<String> toBeAddedList = new ArrayList<>();
        toBeAddedList.addAll(newDeptCodeList);
        toBeAddedList.removeAll(unchangedDeptCodeList);

        for(int i = 0; i < toBeAddedList.size(); i++){
            userMapper.insertUserRDept(condition.getUserid(), toBeAddedList.get(i));
        }

        for(int i = 0; i < toBeDeletedList.size(); i++) {
            userMapper.deleteUserRDept(condition.getUserid(), toBeDeletedList.get(i));
        }

        //update user
        userMapper.updateUser(condition);
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

    /*
    * Helpers
    * */
    private boolean deptExistsInUser(List<Dept> originalDL,String newDept){
        for(int j = 0; j < originalDL.size(); j++){
            String oldDeptCode = originalDL.get(j).getDeptcode();
            if(originalDL.get(j).getDeptcode().equals(newDept))
                return true;
        }
        return false;
    }

    private void printList(List<String> list){
        for(int i = 0; i<list.size(); i++){
            System.out.print(list.get(i)+" ");
            System.out.println();
        }
    }

    public User getUserid(String username, String password) {
        return userMapper.getUserid(username, password);
    }

    public User loginGetUser(String username, String password){return userMapper.loginGetUser(username, password);};


}
