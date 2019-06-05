package com.neuedu.hismedicalsystem.model.po;

import java.util.Date;

public class Shift {
    private int shiftid;
    private String deptname;
    private String username;
    private String realname;
    private boolean aorp;
    private String nmedname;
    private int ration;
    private int userid;

    /* ADD FOR SHIFT ARRANGE*/
    private int uRid;
    private String itemcode;
    private Date dutydate;
    private int balance;

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    public int getShiftid() {
        return shiftid;
    }

    public void setShiftid(int shiftid) {
        this.shiftid = shiftid;
    }

    public Date getDutydate() {
        return dutydate;
    }

    public void setDutydate(Date dutydate) {
        this.dutydate = dutydate;
    }

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

    @Override
    public String toString() {
        return "Shift{" +
                "shiftid=" + shiftid +
                ", deptname='" + deptname + '\'' +
                ", username='" + username + '\'' +
                ", realname='" + realname + '\'' +
                ", aorp=" + aorp +
                ", nmedname='" + nmedname + '\'' +
                ", ration=" + ration +
                ", userid=" + userid +
                ", uRid=" + uRid +
                ", itemcode='" + itemcode + '\'' +
                ", dutydate=" + dutydate +
                ", balance=" + balance +
                '}';
    }
}
