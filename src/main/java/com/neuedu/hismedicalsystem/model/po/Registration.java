package com.neuedu.hismedicalsystem.model.po;

import java.sql.Date;

public class Registration {
    private int regid;
    private boolean newRecord;
    private int order;
    private int pid;
    private int uRid;
    private String itemcode;
    private Date date;
    private int shiftid;

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

    @Override
    public String toString() {
        return "Registration{" +
                "regid=" + regid +
                ", newRecord=" + newRecord +
                ", order=" + order +
                ", pid=" + pid +
                ", uRid=" + uRid +
                ", itemcode='" + itemcode + '\'' +
                ", date=" + date +
                ", shiftid=" + shiftid +
                '}';
    }
}
