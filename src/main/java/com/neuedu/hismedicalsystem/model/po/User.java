package com.neuedu.hismedicalsystem.model.po;

import java.util.List;

public class User {
    private int userid;
    private String username;
    private String pwd;
    private String realname;
    private List<String> deptcodes;
    private String usercat;
    private String position;
    private boolean shiftOrNot;

    public void setUserId(int userid){
        this.userid = userid;
    }

    public int getUserId(){
        return userid;
    }

    public void setUsername(String username){
        this.username = username;
    }

    public String getUsername(){
        return username;
    }

    public void setPwd(String pwd){
        this.pwd = pwd;
    }

    public String getPwd(){
        return pwd;
    }

    public void setRealname(String realname){
        this.realname = realname;
    }

    public String getRealname(){
        return realname;
    }

    public void setUsercat(String usercat){
        this.usercat = usercat;
    }

    public String getUsercat(){
        return usercat;
    }

    public void setPosition(String position){
        this.position = position;
    }

    public String getPosition(){
        return position;
    }

    public void setShiftOrNot(boolean shiftOrNot){
        this.shiftOrNot = shiftOrNot;
    }

    public boolean getShiftOrNot(){
        return shiftOrNot;
    }

    public List<String> getDeptcodes() {
        return deptcodes;
    }

    public void setDeptcodes(List<String> deptcodes) {
        this.deptcodes = deptcodes;
    }
}
