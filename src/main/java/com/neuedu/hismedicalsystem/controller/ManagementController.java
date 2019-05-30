package com.neuedu.hismedicalsystem.controller;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.JSONObject;
import com.neuedu.hismedicalsystem.model.po.*;
import com.neuedu.hismedicalsystem.model.service.*;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.util.Date;
import java.text.SimpleDateFormat;
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
    public void addConst(@RequestBody Constant condition){
        try {
            constService.addConst(condition);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @RequestMapping("/delConst")
    public void delConst(@RequestBody int constid){
        constService.delConst(constid);
    }

    @RequestMapping("/updateConst")
    public void updateConst(@RequestBody Constant condition){
        constService.updateConst(condition);
    }

    @RequestMapping("/consts")
    public List<Constant> getConsts(@RequestBody Constant condition){
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
    public void updateDept(@RequestBody Dept condition){
        deptService.updateDept(condition);
    }

    @RequestMapping("/depts")
    public List<Dept> getDepts(@RequestBody Dept condition){
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

    @RequestMapping("/dis")
    public List<Disease> getDis(@RequestBody Disease condition){ return disService.getDis(condition);}

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

    @RequestMapping("/getRegLevel")
    public List<NonMedic> getRegLevel(){
        return nonMedicService.getRegLevel();
    }

    /**
     * rule
     */
    @Autowired
    private RuleService ruleService;

    @RequestMapping("/getRules")
    public List<Rule> getRules(String deptname){
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

    @RequestMapping("/updateShift")
    public void getShift(@RequestBody JSONObject obj){
        try {
            System.out.println(obj);
            Date startdate = obj.getDate("startdate");
            Date enddate = obj.getDate("enddate");

            shiftService.deleteConflictShifts(startdate,enddate);

            JSONArray params = obj.getJSONArray("shifts");

            List<Shift> insertShifts = new ArrayList<>();

            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");

            for(int i = 0; i < params.size(); i++){
                int ruleid = params.getJSONObject(i).getInteger("ruleid");
                int uRid = ruleService.getURid(ruleid);

                String nmedname = params.getJSONObject(i).getString("nmedname");
                String itemcode = nonMedicService.getRegItemCode(nmedname);

                System.out.println(uRid);
                System.out.println(itemcode);

                Shift tempShift = new Shift();
                tempShift.setAorp(params.getJSONObject(i).getBoolean("aorp"));
                tempShift.setDutydate(params.getJSONObject(i).getDate("dutydate"));
                tempShift.setItemcode(itemcode);
                tempShift.setRation(params.getJSONObject(i).getInteger("ration"));
                tempShift.setUserid(params.getJSONObject(i).getInteger("userid"));
                tempShift.setuRid(uRid);

                insertShifts.add(tempShift);
            }

            shiftService.insertShift(insertShifts);
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
    /**
     * user
     */
    @Autowired
    private UserService userService;


    @RequestMapping("/users")
    public List<User> getUsers(){
        return userService.getUsers();
    }

    @RequestMapping("/updateUser")
    public void updateUser(@RequestBody User condition){
        userService.updateUser(condition);
    }

}
