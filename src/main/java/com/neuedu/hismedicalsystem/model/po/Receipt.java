package com.neuedu.hismedicalsystem.model.po;

import java.sql.Date;

public class Receipt {
    private int recid;
    private String recstate;
    private Date date;
    private int uRid;
    private int chargerid;
    private double totalprice;
    private long pid;
    private String pname;
    //Deprecated
    private String feecode;

    public String getPname() {
        return pname;
    }

    public void setPname(String pname) {
        this.pname = pname;
    }


    public String getFeecode() {
        return feecode;
    }

    public void setFeecode(String feecode) {
        this.feecode = feecode;
    }

    public int getRecid() {
        return recid;
    }

    public void setRecid(int recid) {
        this.recid = recid;
    }

    public String getRecstate() {
        return recstate;
    }

    public void setRecstate(String recstate) {
        this.recstate = recstate;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getuRid() {
        return uRid;
    }

    public void setuRid(int uRid) {
        this.uRid = uRid;
    }

    public int getChargerid() {
        return chargerid;
    }

    public void setChargerid(int chargerid) {
        this.chargerid = chargerid;
    }

    public double getTotalprice() {
        return totalprice;
    }

    public void setTotalprice(double totalprice) {
        this.totalprice = totalprice;
    }

    public long getPid() {
        return pid;
    }

    public void setPid(long pid) {
        this.pid = pid;
    }

    @Override
    public String toString() {
        return "Receipt{" +
                "recid=" + recid +
                ", recstate='" + recstate + '\'' +
                ", date=" + date +
                ", uRid=" + uRid +
                ", chargerid=" + chargerid +
                ", totalprice=" + totalprice +
                ", pid=" + pid +
                '}';
    }
}
