package com.neuedu.hismedicalsystem.model.mapper;

import com.neuedu.hismedicalsystem.model.po.Disease;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface DisMapper {
    public List<Disease> getDis(Disease condition);

    public void delDis(String icdcode);

    void addDis(Disease disease);

    void updateDis(Disease disease);

    void deleteDiseaseFromDiag(@Param("regid") int regid, @Param("icdcode") String icdcode);

    List<Disease> getDiseasesByPinyin(String discode);

    void addDiseaseToDiag(@Param("hpid") int hpid,@Param("diseaseList") List<Disease> diseaseList);
}
