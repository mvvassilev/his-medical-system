package com.neuedu.hismedicalsystem.model.mapper;

import com.neuedu.hismedicalsystem.model.po.Reg;

import java.util.List;

public interface RegMapper {
    public List<Reg> getRegs(Reg condition);
}
