package com.neuedu.hismedicalsystem.model.mapper;

import com.neuedu.hismedicalsystem.model.po.Bill;

import java.util.List;

public interface BillMapper {

    void insertBill(Bill bill);

    List<Bill> getBillsWithCondition(Bill bill);

    void changeStateToPaid(int billId);
}
