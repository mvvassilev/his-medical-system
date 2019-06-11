package com.neuedu.hismedicalsystem.model.service;

import com.neuedu.hismedicalsystem.model.mapper.MedMapper;
import com.neuedu.hismedicalsystem.model.po.Bill;
import com.neuedu.hismedicalsystem.model.po.Medicine;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Service
public class MedService {
    @Resource
    private MedMapper medMapper;

    public List<Medicine> getMed(Medicine condition) {
        return medMapper.getMed(condition);
    }

    @Transactional
    public void addMed(Medicine medicine) throws Exception {
        medMapper.addMed(medicine);
    }

    @Transactional
    public void delMed(String itemcode) {
        medMapper.delMed(itemcode);
    }

    @Transactional
    public void updateMed(Medicine medicine) {
        medMapper.updateMed(medicine);
    }

    @Transactional
    public List<Bill> getBill(int pid){return medMapper.getBill(pid);}

    @Transactional
    public void sendMed(String[] id) {
        medMapper.sendMed(id);
    }

    @Transactional
    public List<Bill> getReturnBill(int pid){return medMapper.getReturnBill(pid);}

    @Transactional
    public Bill getReturnMed(int billid){return medMapper.getReturnMed(billid);}

    @Transactional
    public void returnMed(Bill tempbill){medMapper.returnMed(tempbill);}

    @Transactional
    public void changeCount(int count,int billid){medMapper.changeCount(count,billid);}
}
