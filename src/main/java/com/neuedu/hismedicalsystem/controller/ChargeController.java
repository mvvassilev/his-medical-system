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

    @RequestMapping("/getUnpaidBills")
    public List<Bill> getUnpaidBills(@RequestBody JSONObject obj){
        System.out.println("obj.toString() = " + obj.toString());
        Bill condition = (Bill)JSONObject.toJavaObject(obj.getJSONObject("condition"), Bill.class);
        System.out.println("getBillsWithCondition = " + condition);
        List<Bill> l = billService.getUnpaidBills(condition);
        System.out.println("list = " + l);
        return billService.getUnpaidBills(condition);
    }

    @RequestMapping("/getUndoneBills")
    public List<Bill> getUndoneBills(@RequestBody JSONObject obj){
        Bill condition = (Bill)JSONObject.toJavaObject(obj.getJSONObject("condition"), Bill.class);
        System.out.println("getBillsWithCondition = " + condition);
        List<Bill> l = billService.getUndoneBills(condition);
        System.out.println("list = " + l);
        return billService.getUndoneBills(condition);
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

    @RequestMapping("/refundBill")
    public JSONObject refundBill(@RequestBody JSONArray array){
        List<Bill> bills = JSONObject.parseArray(array.toJSONString(), Bill.class);
        for(Bill bill : bills){
            billService.refundBill(bill.getBillid());
        }
        JSONObject result = new JSONObject();
        result.put("success",true);
        return result;
    }
}