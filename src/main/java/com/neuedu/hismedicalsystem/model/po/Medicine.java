package com.neuedu.hismedicalsystem.model.po;

public class Medicine {
    private String itemcode;
    private String medname;
    private String size;
    private String unit;
    private double price;
    private String type;
    private String feename;

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

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getFeename() {
        return feename;
    }

    public void setFeename(String feename) {
        this.feename = feename;
    }
}
