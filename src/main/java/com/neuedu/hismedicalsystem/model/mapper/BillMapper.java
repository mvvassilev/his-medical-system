package com.neuedu.hismedicalsystem.model.mapper;

import java.util.Date;
import java.util.List;

import com.neuedu.hismedicalsystem.model.po.Bill;


public interface BillMapper {

    void insertBill(Bill bill);

    List<Bill> getUnpaidBills(Bill bill);
    List<Bill> getUndoneBills(Bill bill);
    List<Bill> getBills(Bill bill);

    void deleteBill(int billId);

    void changeStateToPaid(int billId);
    void changeStateToDone(int billId);
}
