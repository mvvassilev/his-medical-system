package com.neuedu.hismedicalsystem.model.service;


import com.neuedu.hismedicalsystem.model.mapper.SettlementMapper;
import com.neuedu.hismedicalsystem.model.po.Settlement;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class SettlementService {
    @Resource
    private SettlementMapper settlementMapper;

    public void test(){
        System.out.println(settlementMapper);
    }

    public List<Settlement> getSettlements(Settlement condition){
        return settlementMapper.getSettlements(condition);
    }
}