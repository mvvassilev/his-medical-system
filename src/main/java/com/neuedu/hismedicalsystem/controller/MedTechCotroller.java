package com.neuedu.hismedicalsystem.controller;

import com.alibaba.fastjson.JSONObject;
import com.neuedu.hismedicalsystem.model.po.Patient;
import com.neuedu.hismedicalsystem.model.service.BillService;
import com.neuedu.hismedicalsystem.model.service.NonMedicService;
import com.neuedu.hismedicalsystem.model.service.PatientService;
import com.neuedu.hismedicalsystem.model.util.FastDFSFile;
import com.neuedu.hismedicalsystem.utils.FastDFSClient;
import com.neuedu.hismedicalsystem.utils.FileManager;
import org.apache.commons.io.IOUtils;
import org.csource.common.MyException;
import org.csource.common.NameValuePair;
import org.csource.fastdfs.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

@CrossOrigin
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
    public List<Patient> loadExamPatients(@RequestBody JSONObject object) {
        return patientService.loadExamPatients(object);
    }

    @RequestMapping("/getPatientByExid")
    public Patient getPatientByExid(@RequestBody JSONObject object) {
        return patientService.getPatientByExid(object);
    }

    @RequestMapping("/addResults")
    public void addResults(@RequestBody JSONObject object) {
        patientService.addResults(object);
    }

    @RequestMapping("/addImg")
    public void addImg(@RequestBody JSONObject object) {
        patientService.addImg(object);
    }

    @RequestMapping("/cancelExam")
    public void cancelExam(@RequestBody JSONObject object) {
        patientService.cancelExam(object);
    }

    /* FastDFS file manage*/
    @RequestMapping("/upload")
    public String singleFileUpload(@RequestParam("picture") MultipartFile picture) {
        if (picture.isEmpty()) {
            return "redirect:uploadStatus";
        }
        try {
            // Get the file and save it somewhere
            String path = saveFile(picture);
            return path;
        } catch (Exception e) {
            //logger.error("upload file failed",e);
        }
        return "redirect:/uploadStatus";
    }

    @GetMapping("/uploadStatus")
    public String uploadStatus() {
        return "uploadStatus";
    }

    /**
     * @param multipartFile
     * @return
     * @throws IOException
     */
    public String saveFile(MultipartFile multipartFile) throws IOException {
        String[] fileAbsolutePath = {};
        String fileName = multipartFile.getOriginalFilename();
        String ext = fileName.substring(fileName.lastIndexOf(".") + 1);
        byte[] file_buff = null;
        InputStream inputStream = multipartFile.getInputStream();
        if (inputStream != null) {
            int len1 = inputStream.available();
            file_buff = new byte[len1];
            inputStream.read(file_buff);
        }
        inputStream.close();
        FastDFSFile file = new FastDFSFile(file_buff, ext);
        try {
            fileAbsolutePath = FastDFSClient.upload(file);  //upload to fastdfs
        } catch (Exception e) {
            //logger.error("upload file Exception!",e);
        }
        if (fileAbsolutePath == null) {
            //logger.error("upload file failed,please upload again!");
        }
        String path = FastDFSClient.getTrackerUrl() + fileAbsolutePath[0] + "/" + fileAbsolutePath[1];
        System.out.println(path);
        return path;
    }

}
