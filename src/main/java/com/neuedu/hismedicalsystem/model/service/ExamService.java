package com.neuedu.hismedicalsystem.model.service;

import com.alibaba.fastjson.JSONObject;
import com.neuedu.hismedicalsystem.model.mapper.ExamMapper;
import com.neuedu.hismedicalsystem.model.po.Exam;
import com.neuedu.hismedicalsystem.model.po.Medicine;
import com.neuedu.hismedicalsystem.model.po.NonMedic;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class ExamService {
    @Resource
    private ExamMapper examMapper;

    public List<Exam> getExamByRegidAndType(int regid, String extype) {
        return examMapper.getExamByRegidAndType(regid, extype);
    }

    public void addItemToExam(JSONObject object) {
        examMapper.addItemToExam(object);
    }

    public void deleteExamState(JSONObject object) {
        examMapper.deleteExamState(object);
    }

    public void updateExamState(JSONObject object) {
        examMapper.updateExamState(object);
    }

    public void saveExamToTemplate(JSONObject object) {
        examMapper.saveExamToTemplate(object);
        int tempid = examMapper.getTempidBack();


        List<String> itemcodes = examMapper.getItemCodeByExid(object.getJSONArray("items"));

        examMapper.saveExamToTemplateRel(itemcodes, tempid);
    }

    public void addTemplateToExam(JSONObject object) {
        List<String> itemcodes = examMapper.getItemCodeByTempid(object.getInteger("tempid"));
        object.put("itemcodes", itemcodes);
        examMapper.addTemplateToExam(object);
    }

}
