package com.neuedu.hismedicalsystem.model.mapper;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.neuedu.hismedicalsystem.model.po.Bill;
import com.neuedu.hismedicalsystem.model.po.FrontPage;
import com.neuedu.hismedicalsystem.model.po.Patient;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface PatientMapper {

    void insertPatient(Patient patient);

    Patient getPatientById(int id);

    int countPatientOfId(int id);

    List<Patient> getPatientsOfUserToday(@Param("userid") int userid, @Param("state") String state);

    List<Patient> getPatientsOfDeptToday(@Param("deptcode") String deptcode, @Param("state") String state);


    void insertHomepage(int regid);

    FrontPage getFrontPageByRegid(int regid);

    int getHpidByRegid(int regid);

    void updateHomepage(FrontPage frontPage);

    Patient getPatientByPid(long pid);

    void updatePatientState(JSONObject object);

    String getBillcatByRegid(Integer regid);

    List<Patient> loadExamPatients(JSONObject object);

    Patient getPatientByExid(JSONObject object);

    void addResultsToHomepage(JSONObject object);

    void addResultsToImage(JSONObject object);

    String getHomePageStateByRegid(JSONObject object);

    Bill getBillBack(Integer exid);

    void addRevokeBill(Bill lastBill);

    void updateExam(Integer exid);
}
