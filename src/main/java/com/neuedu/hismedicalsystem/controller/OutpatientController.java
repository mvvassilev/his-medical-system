package com.neuedu.hismedicalsystem.controller;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.neuedu.hismedicalsystem.model.po.FrontPage;
import com.neuedu.hismedicalsystem.model.po.Patient;
import com.neuedu.hismedicalsystem.model.po.Template_all;
import com.neuedu.hismedicalsystem.model.service.PatientService;
import com.neuedu.hismedicalsystem.model.service.TemplateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/outpatient")
public class OutpatientController {
    /**
     * template
     */
    @Autowired
    private TemplateService templateService;

    @Autowired
    private PatientService patientService;

    @RequestMapping("/temps")
    public List<Template_all> getTemp(@RequestBody Template_all condition) {return templateService.getTemp(condition);}

    @RequestMapping("/addTemp")
    public String addTemp(@RequestBody Template_all template_all) {
        try{
            templateService.addTemp(template_all);
        } catch (Exception e) {
            e.printStackTrace();
            return "{\"result\":false}";
        }
        return "{\"result\":true}";
    }

    @RequestMapping("/delTemp")
    public void delTemp(int tempid){
        templateService.delTemp(tempid);
    }

    @RequestMapping("/item")
    public JSONArray getItem(String temptype){
       return templateService.getItem(temptype);
    }

    @RequestMapping("getDiagnosedPatientsOfUserToday")
    public List<Patient> getDiagnosedPatientsOfUserToday(@RequestBody JSONObject obj){
        return patientService.getPatientsOfUserToday(obj.getInteger("userid"),obj.getString("state"));
    }

    @RequestMapping("getDiagnosedPatientsOfDeptToday")
    public List<Patient> getDiagnosedPatientsOfDeptToday(@RequestBody JSONObject obj){
        return patientService.getPatientsOfDeptToday(obj.getString("deptcode"),obj.getString("state"));
    }

    @RequestMapping("getPatientsOfUserToday")
    public List<Patient> getPatientsOfUserToday(@RequestBody JSONObject obj){
        return patientService.getPatientsOfUserToday(obj.getInteger("userid"),"");

    }

    @RequestMapping("getPatientsOfDeptToday")
    public List<Patient> getPatientsOfDeptToday(@RequestBody JSONObject obj){
       return patientService.getPatientsOfDeptToday(obj.getString("deptcode"),"");
    }

    @RequestMapping("getFrontPageByPid")
    public FrontPage getFrontPageByRegid(long regid){
        return patientService.getFrontPageByRegid(regid);
    }


}
