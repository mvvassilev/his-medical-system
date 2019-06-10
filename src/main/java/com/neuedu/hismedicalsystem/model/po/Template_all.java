package com.neuedu.hismedicalsystem.model.po;

import java.util.Date;
import java.util.List;

public class Template_all {
    private int tempid;
    private String tempname;
    private String temptype;
    private String tempscope;
    private Date createdate;

    private List<NonMedic> nonMedicList;
    private List<Medicine> medicineList;

    public int getTempid() {
        return tempid;
    }

    public void setTempid(int tempid) {
        this.tempid = tempid;
    }

    public String getTempname() {
        return tempname;
    }

    public void setTempname(String tempname) {
        this.tempname = tempname;
    }

    public String getTemptype() {
        return temptype;
    }

    public void setTemptype(String temptype) {
        this.temptype = temptype;
    }

    public String getTempscope() {
        return tempscope;
    }

    public void setTempscope(String tempscope) {
        this.tempscope = tempscope;
    }

    public Date getCreatedate() {
        return createdate;
    }

    public void setCreatedate(Date createdate) {
        this.createdate = createdate;
    }

    public List<NonMedic> getNonMedicList() {
        return nonMedicList;
    }

    public void setNonMedicList(List<NonMedic> nonMedicList) {
        this.nonMedicList = nonMedicList;
    }

    public List<Medicine> getMedicineList() {
        return medicineList;
    }

    public void setMedicineList(List<Medicine> medicineList) {
        this.medicineList = medicineList;
    }
}
