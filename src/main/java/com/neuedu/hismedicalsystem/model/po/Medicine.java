package com.neuedu.hismedicalsystem.model.po;

public class Medicine {
    private String itemcode;
    private String medname;
    private String medsize;
    private String unit;
    private double price;
    private String medtype;
    private String medcat;

    public String getMedsize() {
        return medsize;
    }

    public void setMedsize(String medsize) {
        this.medsize = medsize;
    }

    public String getMedtype() {
        return medtype;
    }

    public void setMedtype(String medtype) {
        this.medtype = medtype;
    }

    public String getMedcat() {
        return medcat;
    }

    public void setMedcat(String medcat) {
        this.medcat = medcat;
    }

    public String getItemcode() {
        return itemcode;
    }

    public void setItemcode(String itemcode) {
        this.itemcode = itemcode;
    }

    public String getMedname() {
        return medname;
    }

    public void setMedname(String medname) {
        this.medname = medname;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

}
