package com.neuedu.hismedicalsystem.controller;

import com.alibaba.fastjson.JSONObject;
import com.neuedu.hismedicalsystem.model.po.NonMedic;
import com.neuedu.hismedicalsystem.model.po.Patient;
import com.neuedu.hismedicalsystem.model.po.Registration;
import com.neuedu.hismedicalsystem.model.po.Shift;
import com.neuedu.hismedicalsystem.model.service.NonMedicService;
import com.neuedu.hismedicalsystem.model.service.RegistrationService;
import com.neuedu.hismedicalsystem.model.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.ParseException;
import java.text.SimpleDateFormat;
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
        String nmedname = obj.getString("registrationLevel");
        System.out.println("*_*_*_*_*_*_*_*_*_*_*_*_*_*_*_*_*_");
        System.out.println("nmedname "+nmedname);
        List<Shift> list = registrationService.getAvailableDoctorList(aorp,deptcode,nmedname);
        System.out.println("*_*_*_*_*_*_*_*_*_*_*_*_*_*_*_*_*_");
        for(Shift shift : list){
            System.out.println(shift.toString());
        }
        return list;
    }

    @RequestMapping("/submitRegistration")
    public String submitRegistration(@RequestBody JSONObject obj){
//        try {
//
        System.out.println("_*_*_*_*_*_*_*_*_*_*_*_*_*_*_*_*_*_");
        System.out.println("Submit Registration");
        System.out.println("_*_*_*_*_*_*_*_*_*_*_*_*_*_*_*_*_*_");


        Patient patient = (Patient) JSONObject.toJavaObject(obj.getJSONObject("patient"), Patient.class);
        System.out.println("patient = " + patient);

        boolean newrecord = obj.getBoolean("newrecord");
        System.out.println("newrecord = " + newrecord);

        String billcat=obj.getString("billcat");
        System.out.println("billcat = " + billcat);

        Shift shift = (Shift)JSONObject.toJavaObject(obj.getJSONObject("selectedShift"), Shift.class);
        System.out.println("shift = " + shift);

        String registrationLevel = shift.getNmedname();
        System.out.println("registrationLevel = " + registrationLevel);

        NonMedic nonMedicItem = new NonMedic();
        nonMedicItem.setNmedname(registrationLevel);

        //Insert patient
        registrationService.insertPatient(patient);

        //Get all the information of registration as non-medic
        NonMedic registrationType = nonMedicService.getNonMedicItems(nonMedicItem).get(0);

        //Add bill for new registration
        registrationService.addRegistrationBill(patient,registrationType,newrecord,billcat);

        //Add registration info into a shift
        registrationService.registerToShift(patient,registrationType,newrecord,shift);

        return "{\"success\":\"true\"}";
    }

    @RequestMapping("/getRegistrationPrice")
    public double getRegistrationPrice(@RequestBody JSONObject obj){
        Shift shift = (Shift)JSONObject.toJavaObject(obj.getJSONObject("selectedShift"), Shift.class);
        System.out.println("shift = " + shift);
        double price = nonMedicService.getPrice(shift.getNmedname());
        System.out.println("Price "+price);
        return price;
    }

    @RequestMapping("/getRegistrations")
    public List<Registration> getRegistrations() {
        List<Registration> rList = registrationService.getRegistrationsByPid(2);
        System.out.println("rList = " + rList);
        return registrationService.getRegistrationsByPid(2);
    }
    
    @RequestMapping("/tryCompletePatientInfo")
    public Patient tryCompletingPatientInfo(@RequestBody Patient p) {
        int id=3;
        System.out.println("Patient "+ registrationService.getPatientInfo(id).toString());
        return registrationService.getPatientInfo(p.getPid());
    }
}
