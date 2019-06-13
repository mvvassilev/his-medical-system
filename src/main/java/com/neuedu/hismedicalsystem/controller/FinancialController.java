package com.neuedu.hismedicalsystem.controller;

import java.util.Date;
import java.util.List;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.neuedu.hismedicalsystem.model.po.Receipt;
import com.neuedu.hismedicalsystem.model.service.ConstService;
import com.neuedu.hismedicalsystem.model.service.ReceiptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/financial")
public class FinancialController {
    @Autowired
    private ReceiptService receiptService;

    @RequestMapping("/getReceiptInfoForDoctor")
    public JSONArray getReceiptInfoForDoctor(){
        return receiptService.getReceiptInfoForDoctor();
    }

    @RequestMapping("/getReceiptInfoForDepartment")
    public JSONArray getReceiptInfoForDepartment() {
        return receiptService.getReceiptInfoForDepartment();
    }

    @RequestMapping("/getReceipts")
    public List<Receipt> getReceipts(@RequestBody JSONObject object) {

        System.out.println("getReceipts->condition = " + object.toString());
        return receiptService.getReceipts(object);
    }
}
