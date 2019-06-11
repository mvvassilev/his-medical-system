package com.neuedu.hismedicalsystem.controller;

import com.neuedu.hismedicalsystem.model.po.Bill;
import com.neuedu.hismedicalsystem.model.po.Medicine;
import com.neuedu.hismedicalsystem.model.service.MedService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("pharmacy")
public class PharmacyController {
    /**
     * medicine management
     */
    @Autowired
    private MedService medService;

    @RequestMapping("/addMed")
    public String addMed(@RequestBody Medicine medicine) {
        System.out.println(medicine.getItemcode());
        try {
            medService.addMed(medicine);
        } catch (Exception e) {
            e.printStackTrace();
            return "{\"result\":false}";
        }
        return "{\"result\":true}";
    }

    @RequestMapping("/delMed")
    public void delMed(String itemcode) {
        medService.delMed(itemcode);
    }

    @RequestMapping("/updateMed")
    public void updateMed(@RequestBody Medicine condition) {
        medService.updateMed(condition);
    }

    @RequestMapping("/med")
    public List<Medicine> getMed(@RequestBody Medicine condition) {
        return medService.getMed(condition);
    }

    /**
     * send medicine
     */
    @RequestMapping("/getBill")
    public List<Bill> getBill(int pid){ return medService.getBill(pid);}

    @RequestMapping("/sendMed")
    public void sendMed(@RequestBody Map<String,Object> params){
        String ids = params.get("ids").toString();
        String[] id=ids.split(",");
        medService.sendMed(id);
    }

    @RequestMapping("/getReturnBill")
    public List<Bill> getReturnBill(int pid){ return medService.getReturnBill(pid);}
}
