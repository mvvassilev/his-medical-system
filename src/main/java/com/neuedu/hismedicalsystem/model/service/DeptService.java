package com.neuedu.hismedicalsystem.model.service;


import com.neuedu.hismedicalsystem.model.mapper.DeptMapper;
import com.neuedu.hismedicalsystem.model.po.Dept;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Service
public class DeptService {
    @Resource
    private DeptMapper deptMapper;

    public void test(){
        System.out.println(deptMapper);
    }

    public List<Dept> getDepts(Dept condition){
        return deptMapper.getDepts(condition);
    }

    @Transactional
    public void addDept(Dept dept) throws Exception {
        deptMapper.addDept(dept);
    }
}