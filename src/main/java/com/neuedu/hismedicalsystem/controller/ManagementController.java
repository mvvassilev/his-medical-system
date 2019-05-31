package com.neuedu.hismedicalsystem.controller;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.JSONObject;
import com.neuedu.hismedicalsystem.model.po.*;
import com.neuedu.hismedicalsystem.model.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/management")
public class ManagementController {

    /**
     * constant
     */
    @Autowired
    private ConstService constService;

    @RequestMapping("/addConst")
    public void addConst(@RequestBody Constant condition) {
        try {
            constService.addConst(condition);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @RequestMapping("/delConst")
    public void delConst(@RequestBody int constid) {
        constService.delConst(constid);
    }

    @RequestMapping("/updateConst")
    public void updateConst(@RequestBody Constant condition) {
        constService.updateConst(condition);
    }

    @RequestMapping("/consts")
    public List<Constant> getConsts(@RequestBody Constant condition) {
        return constService.getConsts(condition);
    }

    /**
     * dept
     */
    @Autowired
    private DeptService deptService;

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

    @RequestMapping("/delDept")
    public void delDept(String deptcode) {
        deptService.delDept(deptcode);
    }

    @RequestMapping("/updateDept")
    public void updateDept(@RequestBody Dept condition) {
        deptService.updateDept(condition);
    }

    @RequestMapping("/depts")
    public List<Dept> getDepts(@RequestBody Dept condition) {
        return deptService.getDepts(condition);
    }

    /**
     * disease
     */
    @Autowired
    private DisService disService;

    @RequestMapping("/addDis")
    public String addDis(@RequestBody Disease disease) {
        System.out.println(disease.getIcdcode());
        try {
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
    public void updateDis(@RequestBody Disease condition) {
        disService.updateDis(condition);
    }

    @RequestMapping("/dis")
    public List<Disease> getDis(@RequestBody Disease condition) {
        return disService.getDis(condition);
    }

    /**
     * non-medical
     */
    @Autowired
    private NonMedicService nonMedicService;

    @RequestMapping("/addNonMedic")
    public String addDept(@RequestBody NonMedic condition) {

        try {
            nonMedicService.addNonMedicItem(condition);
        } catch (Exception e) {
            e.printStackTrace();
            return "{\"result\":false}";
        }
        return "{\"result\":true}";
    }

    @RequestMapping("/delNonMedic")
    public void delNonMedic(String itemcode) {
        nonMedicService.delNonMedicItem(itemcode);
    }

    @RequestMapping("/updateNonMedic")
    public void updateNonMedic(@RequestBody NonMedic condition) {
        nonMedicService.updateNonMedicItem(condition);
    }

    @RequestMapping("/nonmedics")
    public List<NonMedic> getnonmedics(@RequestBody NonMedic condition) {
        return nonMedicService.getNonMedicItems(condition);
    }

    /**
     * rule
     */
    @Autowired
    private RuleService ruleService;

    @RequestMapping("/getRules")
    public List<Rule> getRules(String deptname) {
        return ruleService.getRules(deptname);
    }

    /**
     * shift
     */
    @Autowired
    private ShiftService shiftService;


    @RequestMapping("/shift")
    public List<Shift> getShift(Date dates, Date datee) {
        return shiftService.getShift(dates, datee);
    }

    @RequestMapping("/delShift")
    public void delShift(int shiftid) {
        shiftService.delShift(shiftid);
    }

    /**
     * user
     */
    @Autowired
    private UserService userService;


    @RequestMapping("/users")
    public List<User> getUsers(@RequestBody User condition) {
        return userService.getUsers(condition);
    }

    @RequestMapping("/updateUser")
    public void updateUser(@RequestBody JSONObject obj) {
        try {
            User user = getUserFromJasonObj(obj);
            List<String> deptList = getDeptList(obj);
            userService.updateUser(user,deptList);
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    @RequestMapping("/deleteUser")
    public void deleteUser(String userid) {
        userService.deleteUser(userid);
    }

    @PostMapping(value = "/addUser")
    public void addUser(@RequestBody JSONObject obj) {
        try {
//            User user = getUserFromJasonObj(obj);
            List<String> deptList = getDeptList(obj);
            User user=(User)JSONObject.toJavaObject(obj, User.class);

            System.out.println(user.toString());

            userService.addUser(user,deptList);
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    /*Helpers*/
    public List<String> getDeptList(JSONObject obj){
        JSONArray selectdepts = obj.getJSONArray("selectdepts");
        List<String> deptList = new ArrayList<String>();
        for (int i = 0; i < selectdepts.size(); i++) {
            deptList.add(selectdepts.get(i).toString());
        }
        return deptList;
    }

    public User getUserFromJasonObj(JSONObject obj){
        User user = new User();
        user.setUserid(obj.getInteger("userid"));
        user.setUsername(obj.getString("username"));
        user.setPwd(obj.getString("pwd"));
        user.setRealname(obj.getString("realname"));
        user.setUsercat(obj.getString("usercat"));
        user.setPosition(obj.getString("position"));
        user.setShiftOrNot(obj.getBoolean("shiftOrNot"));
        return user;
    }
}
