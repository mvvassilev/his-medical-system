package com.neuedu.hismedicalsystem.model.mapper;

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

    FrontPage getFrontPageByPid(long pid);
}
