package com.neuedu.hismedicalsystem.model.mapper;

import java.util.Date;
import java.util.List;

import com.alibaba.fastjson.JSONObject;
import com.neuedu.hismedicalsystem.model.po.Bill;
import org.apache.ibatis.annotations.Param;


public interface BillMapper {

    void insertBill(Bill bill);

    List<Bill> getUnpaidBills(Bill bill);
    List<Bill> getUndoneBills(Bill bill);
    List<Bill> getBills(Bill bill);

    void deleteBill(int billId);

    void changeStateToPaid(int billId);

    void addExamToBill(JSONObject object);

    void addPreToBill(JSONObject object);

    int getURidByBillid(@Param("billid") int billid, @Param("treatcat") String treatcat);

    String getTreatcatByBillid(int billid);
}
