package com.neuedu.hismedicalsystem.model.mapper;

import com.neuedu.hismedicalsystem.model.po.Patient;

public interface PatientMapper {

    void insertPatient(Patient patient);

    Patient getPatientById(int id);

    int countPatientOfId(int id);
}
