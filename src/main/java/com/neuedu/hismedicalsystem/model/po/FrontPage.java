package com.neuedu.hismedicalsystem.model.po;

import java.util.List;

public class FrontPage {
    private int hpid;
    private String cheifCP;
    private String curHis;
    private String pastHis;
    private String allergicHis;
    private String situation;
    private String caution;
    private String phyExam;
    private String examAdvice;
    private String disType;
    private String state;
    private String examResult;
    private String treatAdvice;

    private List<Disease> diseaseList;

    public int getHpid() {
        return hpid;
    }

    public void setHpid(int hpid) {
        this.hpid = hpid;
    }

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

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getExamResult() {
        return examResult;
    }

    public void setExamResult(String examResult) {
        this.examResult = examResult;
    }

    public String getTreatAdvice() {
        return treatAdvice;
    }

    public void setTreatAdvice(String treatAdvice) {
        this.treatAdvice = treatAdvice;
    }
}
