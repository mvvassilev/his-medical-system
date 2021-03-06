package com.neuedu.hismedicalsystem.model.po;

import java.sql.Date;

public class Registration {
    private int regid;
    private boolean newRecord;
    private int order;
    private int pid;
    private int uRid;
    private String username;
    private String deptname;
    private String itemcode;
    private String regLevel;
    private Date date;
    private int shiftid;
    private int state;
    private String strState;
    private  double price;

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getStrState() {
        return strState;
    }

    public void setStrState(String strState) {
        this.strState = strState;
    }

    public String getRegLevel() {
        return regLevel;
    }

    public void setRegLevel(String regLevel) {
        this.regLevel = regLevel;
    }

    public int getRegid() {
        return regid;
    }

    public void setRegid(int regid) {
        this.regid = regid;
    }

    public boolean isNewRecord() {
        return newRecord;
    }

    public void setNewRecord(boolean newRecord) {
        this.newRecord = newRecord;
    }

    public int getOrder() {
        return order;
    }

    public void setOrder(int order) {
        this.order = order;
    }

    public int getPid() {
        return pid;
    }

    public void setPid(int pid) {
        this.pid = pid;
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

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getShiftid() {
        return shiftid;
    }

    public void setShiftid(int shiftid) {
        this.shiftid = shiftid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getDeptname() {
        return deptname;
    }

    public void setDeptname(String deptname) {
        this.deptname = deptname;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    @Override
    public String toString() {
        return "Registration{" +
                "regid=" + regid +
                ", newRecord=" + newRecord +
                ", order=" + order +
                ", pid=" + pid +
                ", uRid=" + uRid +
                ", username='" + username + '\'' +
                ", deptname='" + deptname + '\'' +
                ", itemcode='" + itemcode + '\'' +
                ", date=" + date +
                ", shiftid=" + shiftid +
                ", state=" + state +
                '}';
    }
}
