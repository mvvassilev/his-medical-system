package com.neuedu.hismedicalsystem.model.service;


import com.neuedu.hismedicalsystem.model.mapper.RegMapper;
import com.neuedu.hismedicalsystem.model.po.Reg;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class RegService {
    @Resource
    private RegMapper regMapper;

    public void test(){
        System.out.println(regMapper);
    }

    public List<Reg> getRegs(Reg condition){
        return regMapper.getRegs(condition);
    }
}