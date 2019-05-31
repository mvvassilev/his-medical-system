package com.neuedu.hismedicalsystem.model.mapper;

import com.neuedu.hismedicalsystem.model.po.Rule;

import java.util.List;

public interface RuleMapper {
    public List<Rule> getRules(String deptname);

    int getURid(int ruleid);

    void addRule(Rule newRule);

    /*public void delDept(String deptcode);

    void addDept(Dept dept);

    void updateDept(Dept dept);*/
}
