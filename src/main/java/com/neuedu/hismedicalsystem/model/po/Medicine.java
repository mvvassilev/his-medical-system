package com.neuedu.hismedicalsystem.model.po;

public class Medicine {
    private String itemcode;
    private String itemname;
    private String size;
    private String unit;
    private double price;
    private String medtype;
    private String medcat;

    public String getsize() {
        return size;
    }

    public void setsize(String size) {
        this.size = size;
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

    public String getitemname() {
        return itemname;
    }

    public void setitemname(String itemname) {
        this.itemname = itemname;
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
