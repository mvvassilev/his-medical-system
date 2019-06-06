package com.neuedu.hismedicalsystem.model.po;

import java.util.List;

public class FrontPage {
    private String cheifCP;
    private String curHis;
    private String pastHis;
    private String allergicHis;
    private String situation;
    private String caution;
    private String phyExam;
    private String examAdvice;
    private String disType;

    private List<Disease> diseaseList;

    public String getCheifCP() {
        return cheifCP;
    }

    public void setCheifCP(String cheifCP) {
        this.cheifCP = cheifCP;
    }

    public String getCurHis() {
        return curHis;
    }

    public void setCurHis(String curHis) {
        this.curHis = curHis;
    }

    public String getPastHis() {
        return pastHis;
    }

    public void setPastHis(String pastHis) {
        this.pastHis = pastHis;
    }

    public String getAllergicHis() {
        return allergicHis;
    }

    public void setAllergicHis(String allergicHis) {
        this.allergicHis = allergicHis;
    }

    public String getSituation() {
        return situation;
    }

    public void setSituation(String situation) {
        this.situation = situation;
    }

    public String getCaution() {
        return caution;
    }

    public void setCaution(String caution) {
        this.caution = caution;
    }

    public String getPhyExam() {
        return phyExam;
    }

    public void setPhyExam(String phyExam) {
        this.phyExam = phyExam;
    }

    public String getExamAdvice() {
        return examAdvice;
    }

    public void setExamAdvice(String examAdvice) {
        this.examAdvice = examAdvice;
    }

    public String getDisType() {
        return disType;
    }

    public void setDisType(String disType) {
        this.disType = disType;
    }

    public List<Disease> getDiseaseList() {
        return diseaseList;
    }

    public void setDiseaseList(List<Disease> diseaseList) {
        this.diseaseList = diseaseList;
    }
}
