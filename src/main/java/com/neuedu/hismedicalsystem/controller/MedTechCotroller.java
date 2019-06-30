package com.neuedu.hismedicalsystem.controller;

import com.alibaba.fastjson.JSONObject;
import com.neuedu.hismedicalsystem.model.po.NonMedic;
import com.neuedu.hismedicalsystem.model.po.Patient;
import com.neuedu.hismedicalsystem.model.service.BillService;
import com.neuedu.hismedicalsystem.model.service.NonMedicService;
import com.neuedu.hismedicalsystem.model.service.PatientService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/medtech")
public class MedTechCotroller {
    @Autowired
    private BillService billService;

    @Autowired
    private NonMedicService nonMedicService;

    @Autowired
    private PatientService patientService;

    @RequestMapping("/loadExamPatients")
    public List<Patient> loadExamPatients(@RequestBody JSONObject object){
        return patientService.loadExamPatients(object);
    }

    @RequestMapping("/getPatientByExid")
    public Patient getPatientByExid(@RequestBody JSONObject object){
        return patientService.getPatientByExid(object);
    }

    @RequestMapping("/upload")
    public void upload(@RequestParam("picture") MultipartFile picture, HttpServletRequest request) {

        //获取文件在服务器的储存位置
        //String path = request.getSession().getServletContext().getRealPath("/upload");
        String path = "/Users/maxsun/IdeaProjects/his-medical-system/src/main/resources/static/upload";
        File filePath = new File(path);
        //System.out.println("文件的保存路径：" + path);
        if (!filePath.exists() && !filePath.isDirectory()) {
            System.out.println("目录不存在，创建目录:" + filePath);
            filePath.mkdir();
        }

        //获取原始文件名称(包含格式)
        String originalFileName = picture.getOriginalFilename();
        System.out.println("原始文件名称：" + originalFileName);


        //在指定路径下创建一个文件
        File targetFile = new File(path, originalFileName);

        //将文件保存到服务器指定位置
        try {
            picture.transferTo(targetFile);
            System.out.println("上传成功");
        } catch (IOException e) {
            System.out.println("上传失败");
            e.printStackTrace();
        }
    }

    @RequestMapping("/addResults")
    public void addResults(@RequestBody JSONObject object){
        patientService.addResults(object);
    }

    @RequestMapping("/cancelExam")
    public void cancelExam(@RequestBody JSONObject object) {
        patientService.cancelExam(object);
    }
}
