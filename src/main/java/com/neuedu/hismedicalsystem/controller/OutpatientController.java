package com.neuedu.hismedicalsystem.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.JSONObject;
import com.neuedu.hismedicalsystem.model.mapper.DisMapper;
import com.neuedu.hismedicalsystem.model.po.*;
import com.neuedu.hismedicalsystem.model.service.*;
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

    @Autowired
    private DisService disService;

    @Autowired
    private ExamService examService;

    @Autowired
    private NonMedicService nonMedicService;

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

    @RequestMapping("/updateTemp")
    public void updateTemp(int tempid, String tempname, String tempscope){templateService.updateTemp(tempid,tempname,tempscope);}

    @RequestMapping("/addItem")
    public void addItem(int tempid,String itemcode){templateService.addItem(tempid,itemcode);}

    @RequestMapping("/item")
    public JSONArray getItem(String temptype, String itemcode){
       return templateService.getItem(temptype,itemcode);
    }

    @RequestMapping("/getDetails")
    public List<Medicine> getDetails(int tempid){return templateService.getDeatils(tempid);}

    @RequestMapping("/delDetails")
    public void delDetails(int tempRelid){templateService.delDetails(tempRelid);}

    @RequestMapping("/getDiagnosedPatientsOfUserToday")
    public List<Patient> getDiagnosedPatientsOfUserToday(@RequestBody JSONObject obj){
        return patientService.getPatientsOfUserToday(obj.getInteger("userid"),obj.getString("state"));
    }

    @RequestMapping("/getDiagnosedPatientsOfDeptToday")
    public List<Patient> getDiagnosedPatientsOfDeptToday(@RequestBody JSONObject obj){
        return patientService.getPatientsOfDeptToday(obj.getString("deptcode"),obj.getString("state"));
    }

    @RequestMapping("/getPatientsOfUserToday")
    public List<Patient> getPatientsOfUserToday(@RequestBody JSONObject obj){
        return patientService.getPatientsOfUserToday(obj.getInteger("userid"),"");

    }

    @RequestMapping("/getPatientsOfDeptToday")
    public List<Patient> getPatientsOfDeptToday(@RequestBody JSONObject obj){
       return patientService.getPatientsOfDeptToday(obj.getString("deptcode"),"");
    }

    @RequestMapping("/getFrontPageByRegid")
    public FrontPage getFrontPageByRegid(int regid){
        return patientService.getFrontPageByRegid(regid);
    }

    @RequestMapping("/deleteDiseaseFromDiag")
    public void deleteDiseaseFromDiag(int regid, String icdcode){disService.deleteDiseaseFromDiag(regid, icdcode);}

    @RequestMapping("/getDiseasesByPinyin")
    public List<Disease> getDiseasesByPinyin(@RequestBody JSONObject obj){
        return disService.getDiseasesByPinyin(obj.getString("discode"));
    }

    @RequestMapping("/addDiseaseToDiag")
    public void addDiseaseToDiag(@RequestBody JSONObject obj){
        try{
            System.out.println(obj);
            int regid = obj.getInteger("regid");
            int hpid = patientService.getHpidByRegid(regid);

            JSONArray addList = obj.getJSONArray("addList");
            List<Disease> diseaseList = JSONObject.parseArray(addList.toJSONString(), Disease.class);

            disService.addDiseaseToDiag(hpid, diseaseList);
        }catch(JSONException e){
            e.printStackTrace();
        }
    }

    @RequestMapping("/updateHomepage")
    public void updateHomepage(@RequestBody JSONObject obj){
        int hpid = patientService.getHpidByRegid(obj.getInteger("regid"));
        JSONObject tempobj = obj.getJSONObject("homepage");

        FrontPage frontPage = JSONObject.parseObject(tempobj.toJSONString(), FrontPage.class);
        frontPage.setHpid(hpid);

        patientService.updateHomepage(frontPage);
    }

    @RequestMapping("/getExamByRegidAndType")
    public List<Exam> getExamByRegidAndType(int regid, String extype){
        return examService.getExamByRegidAndType(regid, extype);
    }

    @RequestMapping("/getNonMedicByPinyin")
    public List<NonMedic> getNonMedicByPinyin(@RequestBody JSONObject obj){
        String itemcode = obj.getString("itemcode");
        String nmedtype = obj.getString("nmedtype");

        return nonMedicService.getNonMedicByPinyin(itemcode, nmedtype);
    }

    @RequestMapping("/addItemToExam")
    public void addItemToExam(@RequestBody JSONObject object){
        examService.addItemToExam(object);
    }

    @RequestMapping("deleteExamState")
    public void deleteExamState(@RequestBody JSONObject object){
        examService.deleteExamState(object);
    }

    @RequestMapping("updateExamState")
    public void updateExamState(@RequestBody JSONObject object){
        examService.updateExamState(object);
    }

    @RequestMapping("/saveExamToTemplate")
    public void saveExamToTemplate(@RequestBody JSONObject object){
        examService.saveExamToTemplate(object);
    }

    @RequestMapping("/getTemplateForExam")
    public List<Template_all> getTemplateForExam(@RequestBody JSONObject object){
        String temptype = object.getString("temptype");
        return templateService.getTemplateForExam(temptype);
    }

    @RequestMapping("/addTemplateToExam")
    public void addTemplateToExam(@RequestBody JSONObject object){
        examService.addTemplateToExam(object);
    }

    @RequestMapping("/getPatientByPid")
    public Patient getPatientByPid(long pid){
        return patientService.getPatientByPid(pid);
    }

    @RequestMapping("/updatePatientState")
    public void updatePatientState(@RequestBody JSONObject object){
        patientService.updatePatientState(object);
    }
}
