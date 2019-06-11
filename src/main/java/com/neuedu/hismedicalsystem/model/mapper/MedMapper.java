package com.neuedu.hismedicalsystem.model.mapper;

import com.neuedu.hismedicalsystem.model.po.Medicine;

import java.util.List;

public interface MedMapper {
    public List<Medicine> getMed(Medicine condition);

    public void delMed(String itemcode);

    void addMed(Medicine medicine);

    void updateMed(Medicine medicine);

    List<Medicine> getItemCodeByPreid(Integer preid);
}
