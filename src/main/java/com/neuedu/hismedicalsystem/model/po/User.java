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
    private String strShiftOrNot;
    private List<Dept> depts;
    private String strDeptnames = "";

    public String getStrDeptnames() {
        return strDeptnames;
    }

    public void setStrDeptnames(String strDeptnames) {
        this.strDeptnames = strDeptnames;
    }

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
        System.out.println("SetDepts...");
        for(Dept d : depts){
            strDeptnames = strDeptnames + " " + d.getDeptname();
            System.out.println(".."+strDeptnames);
        }
        System.out.println("final"+strDeptnames);

        this.depts = depts;
    }
}
