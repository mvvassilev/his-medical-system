package com.neuedu.hismedicalsystem.model.service;

import com.neuedu.hismedicalsystem.model.mapper.BillMapper;
import com.neuedu.hismedicalsystem.model.mapper.PatientMapper;
import com.neuedu.hismedicalsystem.model.mapper.ShiftMapper;
import com.neuedu.hismedicalsystem.model.mapper.UserMapper;
import com.neuedu.hismedicalsystem.model.po.Bill;
import com.neuedu.hismedicalsystem.model.po.NonMedic;
import com.neuedu.hismedicalsystem.model.po.Patient;
import com.neuedu.hismedicalsystem.model.po.Shift;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

@Service
public class RegistrationService {
    @Resource
    private UserMapper userMapper;

    @Resource
    private ShiftMapper shiftMapper;

    @Resource
    private PatientMapper patientMapper;

    @Resource
    private BillMapper billMapper;



    public List<Shift> getAvailableDoctorList(boolean aorp, String deptcode, String nmedname){
        List<Shift> availableShifts = shiftMapper.getShiftsAvailable(aorp,deptcode,nmedname);
        return availableShifts;
    }

    //For registering a new patient
    public void insertPatient(Patient patient) {
        patient.setState("已挂号");
        patientMapper.insertPatient(patient);
    }

    //add a new registration to the bill table
    public void addRegistrationBill(Patient patient, NonMedic registration, boolean newrecord, String billcat) {
        Bill bill = new Bill();
        double price = registration.getPrice();
        double newrecordPrice = 1;
        if(newrecord)//if new record is required we add 1
            bill.setTotalprice(price + newrecordPrice);
        else
            bill.setTotalprice(price);
        bill.setPid(patient.getPid());
        bill.setCount(1);
        bill.setPaid(false);
        bill.setItemcode(registration.getItemcode());
        bill.setPaid(false);
        bill.setFeecode(registration.getFeecode());
        bill.setDone(true);
        bill.setBillcat(billcat);
        billMapper.insertBill(bill);
    }
}
