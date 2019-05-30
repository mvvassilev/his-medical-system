package com.neuedu.hismedicalsystem.model.po;

import java.util.Date;

public class Shift {
    private int shiftid;
    private Date dutydate;
    private String deptname;
    private String realname;
    private boolean aorp;
    private String nmedname;
    private int ration;

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
}
