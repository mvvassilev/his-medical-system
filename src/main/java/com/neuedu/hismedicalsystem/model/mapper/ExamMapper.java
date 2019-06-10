package com.neuedu.hismedicalsystem.model.mapper;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.neuedu.hismedicalsystem.model.po.Exam;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ExamMapper {
    List<Exam> getExamByRegidAndType(@Param("regid") int regid, @Param("extype") String extype);

    void addItemToExam(JSONObject object);

    void deleteExamState(JSONObject object);

    void updateExamState(JSONObject object);

    void saveExamToTemplate(JSONObject object);

    void saveExamToTemplateRel(@Param("itemcodes") List<String> itemcodes, @Param("tempid") int tempid);

    int getTempidBack();

    List<String> getItemCodeByExid(JSONArray items);

    List<String> getItemCodeByTempid(Integer tempid);

    void addTemplateToExam(JSONObject object);
}
