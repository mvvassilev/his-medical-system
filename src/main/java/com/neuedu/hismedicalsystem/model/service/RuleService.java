package com.neuedu.hismedicalsystem.model.service;

import com.neuedu.hismedicalsystem.model.mapper.RuleMapper;
import com.neuedu.hismedicalsystem.model.po.Rule;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class RuleService {
    @Resource
    private RuleMapper ruleMapper;

    public List<Rule> getRules(String deptname){
        return ruleMapper.getRules(deptname);
    }
/*
    @Transactional
    public void addDept(Dept dept) throws Exception {
        deptMapper.addDept(dept);
    }

    @Transactional
    public void delDept(String deptcode) {deptMapper.delDept(deptcode);}

    @Transactional
    public void updateDept(Dept dept) {deptMapper.updateDept(dept);}*/
}