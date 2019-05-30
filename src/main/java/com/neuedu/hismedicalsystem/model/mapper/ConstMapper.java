package com.neuedu.hismedicalsystem.model.mapper;

import com.neuedu.hismedicalsystem.model.po.Constant;

import java.util.List;

public interface ConstMapper {
    public List<Constant> getConst(Constant condition);

    public void updateConst(Constant condition);

    public void addConst(Constant constant);

    public void delConst(int constid);
}
