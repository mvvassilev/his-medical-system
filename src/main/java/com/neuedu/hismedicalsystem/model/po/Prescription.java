package com.neuedu.hismedicalsystem.model.po;

public class Prescription {
    private int uRid;
    private int regid;
    private String pretype;
    private String state;
    private String prename;

    public int getuRid() {
        return uRid;
    }

    public void setuRid(int uRid) {
        this.uRid = uRid;
    }

    public int getRegid() {
        return regid;
    }

    public void setRegid(int regid) {
        this.regid = regid;
    }

    public String getPretype() {
        return pretype;
    }

    public void setPretype(String pretype) {
        this.pretype = pretype;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getPrename() {
        return prename;
    }

    public void setPrename(String prename) {
        this.prename = prename;
    }
}
