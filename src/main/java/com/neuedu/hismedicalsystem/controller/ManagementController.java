package com.neuedu.hismedicalsystem.controller;

import com.neuedu.hismedicalsystem.model.po.*;
import com.neuedu.hismedicalsystem.model.service.*;
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
    private DisService disService;

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

    @RequestMapping("/dis")
    public List<Disease> getDis(@RequestBody Disease condition){ return disService.getDis(condition);}

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

    @RequestMapping("/addDis")
    public String addDis(@RequestBody Disease disease) {
        System.out.println(disease.getIcdcode());
        try{
            disService.addDis(disease);
        } catch (Exception e) {
            e.printStackTrace();
            return "{\"result\":false}";
        }
        return "{\"result\":true}";
    }

    @RequestMapping("/delDis")
    public void delDis(String icdcode) {
        disService.delDis(icdcode);
    }

    @RequestMapping("/updateDis")
    public void updateDis(@RequestBody Disease condition){
        disService.updateDis(condition);
    }
}
