package com.neuedu.hismedicalsystem.model.mapper;

import com.neuedu.hismedicalsystem.model.po.Settlement;

import java.util.List;

public interface SettlementMapper {
    public List<Settlement> getSettlements(Settlement condition);
}
