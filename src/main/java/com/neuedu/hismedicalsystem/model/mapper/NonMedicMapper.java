package com.neuedu.hismedicalsystem.model.mapper;

import com.neuedu.hismedicalsystem.model.po.NonMedic;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface NonMedicMapper {
    List<NonMedic> getNonMedicItems(NonMedic condition);

    void delNonMedicItem(String itemcode);

    void addNonMedicItem(NonMedic condition);

    void updateNonMedicItem(NonMedic condition);

    List<NonMedic> getRegLevel();

    String getRegItemCode(String itemname);

    double getPrice(String itemname);

    List<NonMedic> getNonMedicByPinyin(@Param("itemcode") String itemcode, @Param("nmedtype") String nmedtype);
}
