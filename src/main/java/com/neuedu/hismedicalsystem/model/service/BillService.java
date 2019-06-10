package com.neuedu.hismedicalsystem.model.service;

import com.neuedu.hismedicalsystem.model.mapper.BillMapper;
import com.neuedu.hismedicalsystem.model.po.Bill;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class BillService {
    @Resource
    private BillMapper billMapper;

    public List<Bill> getBillsWithCondition(Bill bill){
        return billMapper.getBillsWithCondition(bill);
    }

    public void changeStateToPaid(int billId){
        billMapper.changeStateToPaid(billId);
    }
}
