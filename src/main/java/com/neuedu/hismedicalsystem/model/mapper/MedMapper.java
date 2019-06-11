package com.neuedu.hismedicalsystem.model.mapper;

import com.neuedu.hismedicalsystem.model.po.Bill;
import com.neuedu.hismedicalsystem.model.po.Medicine;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface MedMapper {
    public List<Medicine> getMed(Medicine condition);

    public void delMed(String itemcode);

    void addMed(Medicine medicine);

    void updateMed(Medicine medicine);

    public List<Bill> getBill(@Param("pid") int pid);

    public void sendMed(String[] id);
}
