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

import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

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
    public void delConst(@RequestBody Constant c) {

        System.out.println(c.getConstid());
        constService.delConst(c.getConstid());
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

    @RequestMapping("/getDeptSelect")
    public List<Dept> getDeptSelect(){return deptService.getDeptSelect();}

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
    public List<Rule> getRules(String deptname) {
        return ruleService.getRules(deptname);
    }

    @RequestMapping("/addRule")
    public void addRule(@RequestBody JSONObject obj){
        try{
            Rule newRule = new Rule();
            newRule.setRulename(obj.getString("rulename"));
            newRule.setRation(obj.getInteger("ration"));
            newRule.setReglevel(obj.getString("reglevel"));

            newRule.setDeptname(obj.getString("deptname"));
            newRule.setUsername(obj.getString("username"));

            JSONArray amShifts = obj.getJSONArray("checkboxGroup1");
            JSONArray pmShifts = obj.getJSONArray("checkboxGroup2");

            System.out.println(amShifts);
            System.out.println(pmShifts);

            StringBuilder timecodeBuilder = new StringBuilder("00000000000000");
            timecodeBuilder = TimeCodeGenerate(amShifts, timecodeBuilder);
            timecodeBuilder = TimeCodeGenerate(pmShifts,timecodeBuilder);

            newRule.setTimecode(timecodeBuilder.toString());

            ruleService.addRule(newRule);

        }catch (JSONException e) {
            e.printStackTrace();
        }
    }

    private StringBuilder TimeCodeGenerate(JSONArray shifts, StringBuilder timecode) {

        for (int i = 0; i < shifts.size();i++){
            switch(shifts.get(i).toString()){
                case "SUN A.M.":
                    timecode.replace(0,1,"1");
                    break;
                case "SUN P.M.":
                    timecode.replace(1,2,"1");
                    break;
                case "MON A.M.":
                    timecode.replace(2,3,"1");
                    break;
                case "MON P.M.":
                    timecode.replace(3,4,"1");
                    break;
                case "TUE A.M.":
                    timecode.replace(4,5,"1");
                    break;
                case "TUE P.M.":
                    timecode.replace(5,6,"1");
                    break;
                case "WED A.M.":
                    timecode.replace(6,7,"1");
                    break;
                case "WED P.M.":
                    timecode.replace(7,8,"1");
                    break;
                case "THU A.M.":
                    timecode.replace(8,9,"1");
                    break;
                case "THU P.M.":
                    timecode.replace(9,10,"1");
                    break;
                case "FRI A.M.":
                    timecode.replace(10,11,"1");
                    break;
                case "FRI P.M.":
                    timecode.replace(11,12,"1");
                    break;
                case "SAT A.M.":
                    timecode.replace(12,13,"1");
                    break;
                case "SAT P.M.":
                    timecode.replace(13,14,"1");
                    break;

            }

        }
        return timecode;

    }

    /**
     * shift
     */
    @Autowired
    private ShiftService shiftService;


    @RequestMapping("/shift")
    public List<Shift> getShift(java.sql.Date dates, java.sql.Date datee) {
        return shiftService.getShift(dates, datee);
    }

    @RequestMapping("/delShift")
    public void delShift(int shiftid) {
        shiftService.delShift(shiftid);
    }

    @RequestMapping("/delAllShift")
    public void delAllShift(@RequestBody Map<String,Object> params){
        String ids = params.get("ids").toString();
        String[] id=ids.split(",");
        shiftService.delAllShift(id);
    }

    @RequestMapping("/updateShift")
    public void getShift(@RequestBody JSONObject obj){
        try {
            System.out.println(obj);
            Date startdate = obj.getDate("startdate");
            Date enddate = obj.getDate("enddate");
            JSONArray params = obj.getJSONArray("shifts");


            List<Shift> insertShifts = new ArrayList<>();

            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");

            for(int i = 0; i < params.size(); i++){
                int ruleid = params.getJSONObject(i).getInteger("ruleid");
                int uRid = ruleService.getURid(ruleid);

                String itemname = params.getJSONObject(i).getString("itemname");
                String itemcode = nonMedicService.getRegItemCode(itemname);

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
                shiftService.deleteConflictShifts(uRid, startdate, enddate);
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
    public List<User> getUsers(@RequestBody User condition) {
        return userService.getUsers(condition);
    }

    @RequestMapping("/updateUser")
    public String updateUser(@RequestBody JSONObject obj) {
        try {
            System.out.println("/update User Json obj");
            System.out.println(obj.toJSONString());
            User user = (User)JSONObject.toJavaObject(obj, User.class);
            List<String> deptList = getDeptList(obj);
            userService.updateUser(user,deptList);
        } catch (JSONException e) {
            e.printStackTrace();
            return "{\"result\":false}";
        }
        return "{\"result\":true}";
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

    @RequestMapping("checkUserName")
    public boolean checkUserName(String username){
        int conflicts =  userService.checkUserName(username);
        if(conflicts >= 1){
            return false;
        }else{
            return true;
        }
    }

    @RequestMapping("checkLogin")
    public boolean checkLogin(String username, String password){
        int exist = userService.checkLogin(username, password);
        if(exist == 0){
            return false;
        }else{
            return true;
        }
    }
}
