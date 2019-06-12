package com.neuedu.hismedicalsystem.model.service;

import com.alibaba.fastjson.JSONObject;
import com.neuedu.hismedicalsystem.model.mapper.PatientMapper;
import com.neuedu.hismedicalsystem.model.po.FrontPage;
import com.neuedu.hismedicalsystem.model.po.Patient;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class PatientService {
    @Resource
    private PatientMapper patientMapper;

    public List<Patient> getPatientsOfUserToday(int userid, String state){
        return patientMapper.getPatientsOfUserToday(userid, state);
    }

    public List<Patient> getPatientsOfDeptToday(String deptcode, String state){
        return patientMapper.getPatientsOfDeptToday(deptcode, state);
    }

    public FrontPage getFrontPageByRegid(int regid) {
        return patientMapper.getFrontPageByRegid(regid);
    }

    public int getHpidByRegid(int regid) {
        return patientMapper.getHpidByRegid(regid);
    }

    public void updateHomepage(FrontPage frontPage) {
        patientMapper.updateHomepage(frontPage);
    }

    public Patient getPatientByPid(long pid) {
        return patientMapper.getPatientByPid(pid);
    }

    public void updatePatientState(JSONObject object) {
        patientMapper.updatePatientState(object);
    }

    public String getBillcatByRegid(Integer regid) { return patientMapper.getBillcatByRegid(regid);
    }


    public List<Patient> loadExamPatients(JSONObject object) {
        return patientMapper.loadExamPatients(object);
    }

    public Patient getPatientByExid(JSONObject object) {
        return patientMapper.getPatientByExid(object);
    }

    public void addResults(JSONObject object) {
        patientMapper.addResultsToHomepage(object);
        patientMapper.addResultsToImage(object);
    }

    public String getHomePageStateByRegid(JSONObject object) {
        return patientMapper.getHomePageStateByRegid(object);
    }
}
