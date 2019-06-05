package com.neuedu.hismedicalsystem.controller;

import com.alibaba.fastjson.JSONObject;
import com.neuedu.hismedicalsystem.model.po.NonMedic;
import com.neuedu.hismedicalsystem.model.po.Patient;
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
        String deptcode = obj.getString("dept");
        boolean aorp = obj.getBoolean("aorp");
        String nmedname = obj.getString("registrationLevel");
        List<Shift> list = registrationService.getAvailableDoctorList(aorp,deptcode,nmedname);
        for(Shift shift : list){
            System.out.println(shift.toString());
        }
        return list;
    }

    @RequestMapping("/submitRegistration")
    public String submitRegistration(@RequestBody JSONObject obj){
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            Date date = sdf.parse("1998-08-08");
            java.sql.Date sqlDate = new java.sql.Date(date.getTime());

            //Patient
            Patient patient = new Patient
                    (2,"Wilson",true,21, sqlDate,"北京");

            boolean newrecord = false;
            String registrationLevel = "普通号";
            String billcat="自费";

            NonMedic nonMedicItem = new NonMedic();
            nonMedicItem.setNmedname(registrationLevel);

            Shift shift = new Shift();
            shift.setNmedname("普通号");
            shift.setShiftid(1);
            shift.setuRid(26);

            //Insert patient
            registrationService.insertPatient(patient);

            //Get all the information of registration as non-medic
            NonMedic registrationType = nonMedicService.getNonMedicItems(nonMedicItem).get(0);

            //Add bill for new registration
            registrationService.addRegistrationBill(patient,registrationType,newrecord,billcat);

            //Add registration info into a shift
            registrationService.registerToShift(patient,registrationType,newrecord,shift);

        } catch (ParseException e) {
            e.printStackTrace();
        }
        return "{\"success\":\"true\"}";
    }

    @RequestMapping("/getRegistrationPrice")
    public double getRegistrationPrice(){
        Shift shift = new Shift();
        shift.setNmedname("普通号");
        double price = nonMedicService.getPrice(shift.getNmedname());
        System.out.println("Price "+price);
        return price;
    }

    @RequestMapping("/tryCompletePatientInfo")
    public Patient tryCompletingPatientInfo(@RequestBody Patient p) {
        int id=3;
        System.out.println("Patient "+ registrationService.getPatientInfo(id).toString());
        return registrationService.getPatientInfo(p.getPid());
    }
}
