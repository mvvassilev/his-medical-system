package com.neuedu.hismedicalsystem.model.po;

public class NonMedic {
    private String itemcode;
    private String feecode;
    private String deptcode;
    private String itemname;
    private String size;
    private double price;

    public String getItemcode() {
        return itemcode;
    }

    public void setItemcode(String itemcode) {
        this.itemcode = itemcode;
    }

    public String getFeecode() {
        return feecode;
    }

    public void setFeecode(String feecode) {
        this.feecode = feecode;
    }

    public String getDeptcode() {
        return deptcode;
    }

    public void setDeptcode(String deptcode) {
        this.deptcode = deptcode;
    }

    public String getItemname() {
        return itemname;
    }

    public void setItemname(String itemname) {
        this.itemname = itemname;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "NonMedic{" +
                "itemcode='" + itemcode + '\'' +
                ", feecode='" + feecode + '\'' +
                ", deptcode='" + deptcode + '\'' +
                ", itemname='" + itemname + '\'' +
                ", size='" + size + '\'' +
                ", price=" + price +
                '}';
    }
}
