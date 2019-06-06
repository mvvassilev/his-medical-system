package com.neuedu.hismedicalsystem.model.service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
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

    public List<Shift> getAvailableDoctorList(boolean aorp, String deptcode, String itemname){
        List<Shift> availableShifts = shiftMapper.getShiftsAvailable(aorp,deptcode,itemname);
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

        System.out.println("_*_*_*_*_*_*_*_*_*_*_*_*_*_*_*_*_*_");
        System.out.println("registerToShift");
        System.out.println("register = " + register);
        System.out.println("_*_*_*_*_*_*_*_*_*_*_*_*_*_*_*_*_*_");

        registrationMapper.addRegister(register);
        //Deduct one in balance field for the shift
        shiftMapper.deductOneBalance(shiftid);
        //Create Homepage For this registration
        patientMapper.insertHomepage(register.getRegid());
    }

    //TODO:DELETE TEST
    public void test(){
        Registration register = new Registration();
        register.setShiftid(1);
        register.setOrder(2);
        register.setPid(2394);
        register.setuRid(234);
        register.setItemcode("testing");
        register.setNewRecord(true);

        int regid = registrationMapper.addRegister(register);
        System.out.println("regid = " + register.getRegid());
    }

    public JSONObject getPatientInfo(int id) {
        Patient p;
        JSONObject result = new JSONObject();
        if(patientMapper.countPatientOfId(id)==1){
            p = patientMapper.getPatientById(id);
            result.put("patient",(JSONObject) JSON.toJSON(p));
            result.put("exists","Yes");
        }
        else{
            p =  new Patient();
            result.put("patient",(JSONObject) JSON.toJSON(p));
            result.put("exists","No");
        }
        return result;
    }

    public List<Registration> getRegistrationsByPid(int id){
        return registrationMapper.getRegistrationsByPid(id);
    }

}
