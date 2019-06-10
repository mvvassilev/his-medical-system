package com.neuedu.hismedicalsystem.controller;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.neuedu.hismedicalsystem.model.po.Bill;
import com.neuedu.hismedicalsystem.model.service.BillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/charge")
public class ChargeController {
    @Autowired
    BillService billService;

    @RequestMapping("/getBillsWithCondition")
    public List<Bill> getBillsWithCondition(@RequestBody JSONObject obj){
        Bill condition = (Bill)JSONObject.toJavaObject(obj.getJSONObject("condition"), Bill.class);
        System.out.println("getBillsWithCondition = " + condition);
        List<Bill> l = billService.getBillsWithCondition(condition);
        System.out.println("list = " + l);
        return billService.getBillsWithCondition(condition);
    }

    @RequestMapping("/changeStatesToPaid")
    public JSONObject changeStatesToPaid(@RequestBody JSONArray array){
        List<Bill> bills = JSONObject.parseArray(array.toJSONString(), Bill.class);
        System.out.println("changeStatesToPaid bills = " + bills);
        for(Bill bill : bills){
            billService.changeStateToPaid(bill.getBillid());
        }

        JSONObject result = new JSONObject();
        result.put("success",true);
        return result;
    }
}
