package com.neuedu.hismedicalsystem.model.mapper;

import com.neuedu.hismedicalsystem.model.po.Medicine;
import com.neuedu.hismedicalsystem.model.po.Prescription;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface PrescriptionMapper {
    public List<Prescription> getPre(Prescription condition);

    public void addPre(@Param("uRid")int uRid, @Param("regid")int regid,
                       @Param("pretype")String pretype,@Param("prename")String prename);

    public void delPre(int preid);

    public void changeState(@Param("state") String state,@Param("preid")int preid);

    public List<Medicine> getItem(int preid);

    public List<Medicine> getMed(@Param("itemcode") String itemcode,@Param("pretype") String pretype);

    public void addMed(@Param("preid") int preid, @Param("itemcode") String itemcode, @Param("count") int count);

    public void delMed(int preRelid);

    public List<Prescription> getPreH(Prescription condition);
}

