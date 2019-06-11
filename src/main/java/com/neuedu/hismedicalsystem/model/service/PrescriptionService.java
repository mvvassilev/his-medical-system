package com.neuedu.hismedicalsystem.model.service;

import com.neuedu.hismedicalsystem.model.mapper.PrescriptionMapper;
import com.neuedu.hismedicalsystem.model.po.Medicine;
import com.neuedu.hismedicalsystem.model.po.Prescription;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Service
public class PrescriptionService {
    @Resource
    private PrescriptionMapper prescriptionMapper;

    public List<Prescription> getPre(Prescription condition){ return prescriptionMapper.getPre(condition);}

    public List<Prescription> getPreH(Prescription condition){ return prescriptionMapper.getPreH(condition);}

    @Transactional
    public void addPre(int uRid, int regid, String pretype, String prename){
        prescriptionMapper.addPre(uRid, regid, pretype, prename);
    }

    @Transactional
    public void delPre(int preid){prescriptionMapper.delPre(preid);}

    @Transactional
    public void changeState(String state,int preid){prescriptionMapper.changeState(state, preid);}

    @Transactional
    public List<Medicine> getItem(int preid){return prescriptionMapper.getItem(preid);}

    @Transactional
    public List<Medicine> getMed(String itemcode){return prescriptionMapper.getMed(itemcode);}

    @Transactional
    public void addMed(int preid,String itemcode, int count){prescriptionMapper.addMed(preid, itemcode, count);}

    @Transactional
    public void delMed(int preRelid){prescriptionMapper.delMed(preRelid);}
}
