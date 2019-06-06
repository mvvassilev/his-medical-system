package com.neuedu.hismedicalsystem.model.service;

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

    public FrontPage getFrontPageByPid(long pid) {
        return patientMapper.getFrontPageByPid(pid);
    }
}
