package com.neuedu.hismedicalsystem.model.service;

import com.neuedu.hismedicalsystem.model.mapper.PrescriptionMapper;
import com.neuedu.hismedicalsystem.model.po.Prescription;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class PrescriptionService {
    @Resource
    private PrescriptionMapper prescriptionMapper;
    public void test(){
        System.out.println(prescriptionMapper);
    }

    public List<Prescription> getPre(Prescription condition){ return prescriptionMapper.getPre(condition);}
}
