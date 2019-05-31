package com.neuedu.hismedicalsystem.model.po;

import java.util.List;

public class User {
    private int userid;
    private String username;
    private String pwd;
    private String realname;
    private String usercat;
    private String position;
    private boolean shiftOrNot;
    private List<Dept> depts;

//    public User(int userid, String username, String pwd, String realname, String usercat, String position, boolean shiftOrNot, List<Dept> depts) {
//        this.userid = userid;
//        this.username = username;
//        this.pwd = pwd;
//        this.realname = realname;
//        this.usercat = usercat;
//        this.position = position;
//        this.shiftOrNot = shiftOrNot;
//        this.depts = depts;
//    }
//
//    public User(int userid, String username, String pwd, String realname, String usercat, String position, boolean shiftOrNot) {
//        this.userid = userid;
//        this.username = username;
//        this.pwd = pwd;
//        this.realname = realname;
//        this.usercat = usercat;
//        this.position = position;
//        this.shiftOrNot = shiftOrNot;
//    }

    public int getUserid() {
        return userid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public String getRealname() {
        return realname;
    }

    public void setRealname(String realname) {
        this.realname = realname;
    }

    public String getUsercat() {
        return usercat;
    }

    public void setUsercat(String usercat) {
        this.usercat = usercat;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public boolean isShiftOrNot() {
        return shiftOrNot;
    }

    public void setShiftOrNot(boolean shiftOrNot) {
        this.shiftOrNot = shiftOrNot;
    }

    public List<Dept> getDepts() {
        return depts;
    }

    public void setDepts(List<Dept> depts) {
        this.depts = depts;
    }

    @Override
    public String toString() {
        return "User{" +
                "userid=" + userid +
                ", username='" + username + '\'' +
                ", pwd='" + pwd + '\'' +
                ", realname='" + realname + '\'' +
                ", usercat='" + usercat + '\'' +
                ", position='" + position + '\'' +
                ", shiftOrNot=" + shiftOrNot +
                '}';
    }
}
