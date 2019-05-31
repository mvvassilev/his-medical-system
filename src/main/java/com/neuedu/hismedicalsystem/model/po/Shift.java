package com.neuedu.hismedicalsystem.model.po;

import java.util.Date;

public class Shift {
    private int shiftid;
    private Date dutydate;

    public Date getDutydate() {
        return dutydate;
    }

    public void setDutydate(Date dutydate) {
        this.dutydate = dutydate;
    }

    private String deptname;
    private String username;
    private String realname;
    private boolean aorp;
    private String nmedname;
    private int ration;
    private int userid;

    public String getDeptname() {
        return deptname;
    }

    public void setDeptname(String deptname) {
        this.deptname = deptname;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getRealname() {
        return realname;
    }

    public void setRealname(String realname) {
        this.realname = realname;
    }

    public boolean isAorp() {
        return aorp;
    }

    public void setAorp(boolean aorp) {
        this.aorp = aorp;
    }

    public String getNmedname() {
        return nmedname;
    }

    public void setNmedname(String nmedname) {
        this.nmedname = nmedname;
    }

    public int getRation() {
        return ration;
    }

    public void setRation(int ration) {
        this.ration = ration;
    }

    public int getUserid() {
        return userid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }

    /* ADD FOR SHIFT ARRANGE*/
    private int uRid;
    private String itemcode;

    public int getuRid() {
        return uRid;
    }

    public void setuRid(int uRid) {
        this.uRid = uRid;
    }

    public String getItemcode() {
        return itemcode;
    }

    public void setItemcode(String itemcode) {
        this.itemcode = itemcode;
    }


}
