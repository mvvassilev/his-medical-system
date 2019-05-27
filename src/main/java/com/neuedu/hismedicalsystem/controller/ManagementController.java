package com.neuedu.hismedicalsystem.controller;

import com.neuedu.hismedicalsystem.model.po.Dept;
import com.neuedu.hismedicalsystem.model.po.User;
import com.neuedu.hismedicalsystem.model.po.Reg;
import com.neuedu.hismedicalsystem.model.po.Settlement;
import com.neuedu.hismedicalsystem.model.service.DeptService;
import com.neuedu.hismedicalsystem.model.service.UserService;
import com.neuedu.hismedicalsystem.model.service.RegService;
import com.neuedu.hismedicalsystem.model.service.SettlementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.sql.Date;
import java.util.List;

@RestController
@RequestMapping("/management")
public class ManagementController {

    @Autowired
    private UserService userService;

    @Autowired
    private DeptService deptService;

    @Autowired
    private RegService regService;

    @Autowired
    private SettlementService settlementService;

    @RequestMapping("/users")
    public List<User> getUsers(@RequestBody User condition){
        return userService.getUsers(condition);
    }

    @RequestMapping("/updateUser")
    public void updateUser(@RequestBody User condition){
        userService.updateUser(condition);
    }

    @RequestMapping("/depts")
    public List<Dept> getDepts(@RequestBody Dept condition){
        return deptService.getDepts(condition);
    }

    @RequestMapping("/addDept")
    public String addDept(@RequestBody Dept dept) {
        System.out.println(dept.getDeptcode());
        try{
            deptService.addDept(dept);
        } catch (Exception e) {
            e.printStackTrace();
            return "{\"result\":false}";
        }
        return "{\"result\":true}";
    }

    @RequestMapping("/updateDept")
    public void updateDept(@RequestBody Dept condition){
        deptService.updateDept(condition);
    }


    @RequestMapping("/registration")
    public List<Reg> getRegs(@RequestBody Reg condition){
        return regService.getRegs(condition);
    }

    @RequestMapping("/delDept")
    public void delDept(String deptcode) {
        deptService.delDept(deptcode);
    }

    @RequestMapping("/settlement")
    public List<Settlement> getSettlements(@RequestBody Settlement condition){
        return settlementService.getSettlements(condition);
    }
}
