package com.neuedu.hismedicalsystem.model.mapper;

import java.util.Date;
import java.util.List;

import com.alibaba.fastjson.JSONObject;
import com.neuedu.hismedicalsystem.model.po.Bill;


public interface BillMapper {

    void insertBill(Bill bill);

    List<Bill> getBillsWithCondition(Bill bill);

    void changeStateToPaid(int billId);

    void addExamToBill(JSONObject object);

    void addPreToBill(JSONObject object);
}
