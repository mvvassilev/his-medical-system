package com.neuedu.hismedicalsystem.model.po;

import java.sql.Date;

public class Bill {
    private int billid;
    private double totalprice;
    private int pid;

    public int getPid() {
        return pid;
    }

    public void setPid(int pid) {
        this.pid = pid;
    }

    private int count;
    private Date billdate;
    private boolean isPaid;
    private String itemcode;
    private String itemname;

    private boolean isPrint;
    private String feecode;
    private String feename;

    private boolean isDone;
    private String billcat;

    private String realname;
    private String prename;
    private String treatcat;
    private int treatid;
    private int recid;

    public String getTreatcat() {
        return treatcat;
    }

    public void setTreatcat(String treatcat) {
        this.treatcat = treatcat;
    }

    public int getTreatid() {
        return treatid;
    }

    public void setTreatid(int treatid) {
        this.treatid = treatid;
    }

    public int getRecid() {
        return recid;
    }

    public void setRecid(int recid) {
        this.recid = recid;
    }

    public String getRealname() {
        return realname;
    }

    public void setRealname(String realname) {
        this.realname = realname;
    }

    public String getPrename() {
        return prename;
    }

    public void setPrename(String prename) {
        this.prename = prename;
    }

    public String getItemname() {
        return itemname;
    }

    public void setItemname(String itemname) {
        this.itemname = itemname;
    }

    public String getFeename() {
        return feename;
    }

    public void setFeename(String feename) {
        this.feename = feename;
    }

    public int getBillid() {
        return billid;
    }

    public void setBillid(int billid) {
        this.billid = billid;
    }

    public double getTotalprice() {
        return totalprice;
    }

    public void setTotalprice(double totalprice) {
        this.totalprice = totalprice;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public Date getBilldate() {
        return billdate;
    }

    public void setBilldate(Date billdate) {
        this.billdate = billdate;
    }

    public boolean isPaid() {
        return isPaid;
    }

    public void setPaid(boolean paid) {
        isPaid = paid;
    }

    public String getItemcode() {
        return itemcode;
    }

    public void setItemcode(String itemcode) {
        this.itemcode = itemcode;
    }

    public boolean isPrint() {
        return isPrint;
    }

    public void setPrint(boolean print) {
        isPrint = print;
    }

    public String getFeecode() {
        return feecode;
    }

    public void setFeecode(String feecode) {
        this.feecode = feecode;
    }

    public boolean isDone() {
        return isDone;
    }

    public void setDone(boolean done) {
        isDone = done;
    }

    public String getBillcat() {
        return billcat;
    }

    public void setBillcat(String billcat) {
        this.billcat = billcat;
    }

    @Override
    public String toString() {
        return "Bill{" +
                "billid=" + billid +
                ", totalprice=" + totalprice +
                ", pid=" + pid +
                ", count=" + count +
                ", billdate=" + billdate +
                ", isPaid=" + isPaid +
                ", itemcode='" + itemcode + '\'' +
                ", isPrint=" + isPrint +
                ", feecode='" + feecode + '\'' +
                ", isDone=" + isDone +
                ", billcat='" + billcat + '\'' +
                '}';
    }
}
