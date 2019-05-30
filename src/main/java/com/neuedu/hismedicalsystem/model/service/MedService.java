package com.neuedu.hismedicalsystem.model.service;

import com.neuedu.hismedicalsystem.model.mapper.MedMapper;
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
}
