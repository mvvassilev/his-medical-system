package com.neuedu.hismedicalsystem.model.po;

public class User {
    private int userid;
    private String username;
    private String pwd;
    private String realname;
    private String deptcode;
    private String usercat;
    private String position;
    private boolean shiftOrNot;

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

    public String getDeptcode() {
        return deptcode;
    }

    public void setDeptcode(String deptcode) {
        this.deptcode = deptcode;
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
}
