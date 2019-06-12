package com.neuedu.hismedicalsystem.controller;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.neuedu.hismedicalsystem.model.po.*;
import com.neuedu.hismedicalsystem.model.service.NonMedicService;
import com.neuedu.hismedicalsystem.model.service.RegistrationService;
import com.neuedu.hismedicalsystem.model.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/registration")
public class RegistrationController {

    @Autowired
    private NonMedicService nonMedicService;

    @Autowired
    private RegistrationService registrationService;

    @RequestMapping("/getDoctorsAvailable")
    public List<Shift> getDoctorsAvailable(@RequestBody JSONObject obj) {
        String deptcode = obj.getString("deptcode");
        boolean aorp = obj.getBoolean("aorp");
        String itemname = obj.getString("registrationLevel");
        System.out.println("*_*_*_*_*_*_*_*_*_*_*_*_*_*_*_*_*_");
        System.out.println("itemname "+itemname);
        List<Shift> list = registrationService.getAvailableDoctorList(aorp,deptcode,itemname);
        System.out.println("*_*_*_*_*_*_*_*_*_*_*_*_*_*_*_*_*_");
        for(Shift shift : list){
            System.out.println(shift.toString());
        }
        return list;
    }

    @RequestMapping("/submitRegistration")
    public List<Bill> submitRegistration(@RequestBody JSONObject obj) {

        System.out.println("_*_*_*_*_*_*_*_*_*_*_*_*_*_*_*_*_*_");
        System.out.println("Submit Registration");
        System.out.println("_*_*_*_*_*_*_*_*_*_*_*_*_*_*_*_*_*_");


        Patient patient = (Patient) JSONObject.toJavaObject(obj.getJSONObject("patient"), Patient.class);
        System.out.println("patient = " + patient);

        Boolean patientExists = obj.getBoolean("patientExists");
        System.out.println("patientExists = " + patientExists);

        boolean newrecord = obj.getBoolean("newrecord");
        System.out.println("newrecord = " + newrecord);

        String billcat=obj.getString("billcat");
        System.out.println("billcat = " + billcat);

        Shift shift = (Shift)JSONObject.toJavaObject(obj.getJSONObject("selectedShift"), Shift.class);
        System.out.println("shift = " + shift);

        String registrationLevel = shift.getItemname();
        System.out.println("registrationLevel = " + registrationLevel);



        NonMedic nonMedicItem = new NonMedic();
        nonMedicItem.setItemname(registrationLevel);

        //Insert patient
        if(!patientExists) {
            registrationService.insertPatient(patient);
        }
        //Get all the information of registration as non-medic
        NonMedic registrationType = nonMedicService.getNonMedicItems(nonMedicItem).get(0);

        //Add bill for new registration
        Bill insertedBill = registrationService.addRegistrationBill(patient, registrationType, newrecord, billcat);

        //Add registration info into a shift
        registrationService.registerToShift(patient,registrationType,newrecord,shift);

        List<Bill> bills = new ArrayList<>();
        bills.add(insertedBill);
        return bills;
    }

    @RequestMapping("/getRegistrationPrice")
    public double getRegistrationPrice(@RequestBody JSONObject obj){
        Shift shift = (Shift)JSONObject.toJavaObject(obj.getJSONObject("selectedShift"), Shift.class);
        System.out.println("shift = " + shift);
        double price = nonMedicService.getPrice(shift.getItemname());
        System.out.println("Price "+price);
        return price;
    }

    @RequestMapping("/getCancellableRegistrationsByPid")
    public List<Registration> getRegistrations(@RequestBody JSONObject obj) {
        int id = obj.getInteger("id");
        List<Registration> rList = registrationService.getCancellableRegistrationsByPid(id);
        System.out.println("rList = " + rList);
        return registrationService.getCancellableRegistrationsByPid(id);
    }
    
    @RequestMapping("/tryCompletePatientInfo")
    public JSONObject tryCompletingPatientInfo(@RequestBody JSONObject obj) {
        int id = obj.getInteger("id");
        System.out.println("id = " + obj.getInteger("id"));
        System.out.println("Patient "+ registrationService.getPatientInfo(id));
//        return registrationService.getPatientInfo(p.getPid());

        return registrationService.getPatientInfo(id);
    }

    @RequestMapping("/deleteRegs")
    public JSONObject deleteRegs(@RequestBody JSONArray array){
        List<Registration> regs = JSONObject.parseArray(array.toJSONString(), Registration.class);
        System.out.println("regs = " + regs);
        registrationService.deleteRegs(regs);

        JSONObject result = new JSONObject();
        result.put("success",true);
        return result;
    }

    @RequestMapping("/test")
    public void test(@RequestBody JSONObject obj) {
        registrationService.test();
    }
}
