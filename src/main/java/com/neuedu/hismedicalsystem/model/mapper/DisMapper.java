package com.neuedu.hismedicalsystem.model.mapper;

import com.neuedu.hismedicalsystem.model.po.Disease;

import java.util.List;

public interface DisMapper {
    public List<Disease> getDis(Disease condition);
    public void delDis(String icdcode);

    void addDis(Disease disease);

    void updateDis(Disease disease);
}
