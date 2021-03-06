package com.neuedu.hismedicalsystem.model.service;

import com.neuedu.hismedicalsystem.model.mapper.NonMedicMapper;
import com.neuedu.hismedicalsystem.model.po.NonMedic;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Service
public class NonMedicService {
    @Resource
    private NonMedicMapper nonMedicMapper;

    public String getRegItemCode(String itemname) {
        return nonMedicMapper.getRegItemCode(itemname);
    }

    public List<NonMedic> getNonMedicItems(NonMedic condition) {
        return nonMedicMapper.getNonMedicItems(condition);
    }

    @Transactional
    public void addNonMedicItem(NonMedic condition) throws Exception {
        nonMedicMapper.addNonMedicItem(condition);
    }

    @Transactional
    public void delNonMedicItem(String itemcode) {
        nonMedicMapper.delNonMedicItem(itemcode);
    }

    @Transactional
    public void updateNonMedicItem(NonMedic condition) {
        nonMedicMapper.updateNonMedicItem(condition);
    }

    @Transactional
    public List<NonMedic> getRegLevel() {
        return nonMedicMapper.getRegLevel();
    }

    public double getPrice(String itemname) {
        return nonMedicMapper.getPrice(itemname);
    }

    public List<NonMedic> getNonMedicByPinyin(String itemcode, String nmedtype) {
        return nonMedicMapper.getNonMedicByPinyin(itemcode, nmedtype);
    }
}