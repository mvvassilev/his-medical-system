package com.neuedu.hismedicalsystem.model.service;


import com.neuedu.hismedicalsystem.model.mapper.ConstMapper;
import com.neuedu.hismedicalsystem.model.po.Constant;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Service
public class ConstService {
    @Resource
    private ConstMapper constMapper;

    public void test(){
        System.out.println(constMapper);
    }

    public List<Constant> getConsts(Constant condition) {
        return constMapper.getConsts(condition);
    }

    @Transactional
    public void updateConst(Constant condition){ constMapper.updateConst(condition);}

    @Transactional
    public void addConst(Constant constant) throws Exception {
        constMapper.addConst(constant);
    }

    @Transactional
    public void delConst(int constid) {constMapper.delConst(constid);}
}