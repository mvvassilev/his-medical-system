package com.neuedu.hismedicalsystem.model.service;

import com.neuedu.hismedicalsystem.model.mapper.*;
import com.neuedu.hismedicalsystem.model.po.*;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
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

    @Resource
    private RegistrationMapper registrationMapper;

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
        bill.setPaid(true);
        bill.setItemcode(registration.getItemcode());
        bill.setPaid(false);
        bill.setFeecode(registration.getFeecode());
        bill.setDone(true);
        bill.setBillcat(billcat);
        billMapper.insertBill(bill);
    }

    public void registerToShift(Patient patient, NonMedic registrationType, boolean newrecord, Shift shift) {
        Registration register = new Registration();
        register.setNewRecord(newrecord);

        //Get the current order for the patient ( maximum in shift +1 )
        int shiftid = shift.getShiftid();
        int currentOrder = 1;
        int countRegsInShift = registrationMapper.countRegsInShift(shiftid);
        if(countRegsInShift > 0)
            currentOrder = registrationMapper.getCurrentOrder(shift.getShiftid()) + 1;
        register.setOrder(currentOrder);

        register.setPid(patient.getPid());
        register.setuRid(shift.getuRid());
        register.setItemcode(registrationType.getItemcode());
        register.setShiftid(shiftid);
        registrationMapper.addRegister(register);

        //Deduct one in balance field for the shift
        shiftMapper.deductOneBalance(shiftid);
    }

    public Patient getPatientInfo(int id) {
        if(patientMapper.countPatientOfId(id)==1)
            return patientMapper.getPatientById(id);
        else
            return new Patient();
    }

    public List<Registration> getRegistrationsByPid(int id){
        return registrationMapper.getRegistrationsByPid(id);
    }

}
