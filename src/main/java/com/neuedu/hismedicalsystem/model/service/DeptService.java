package com.neuedu.hismedicalsystem.model.service;


import com.neuedu.hismedicalsystem.model.mapper.DeptMapper;
import com.neuedu.hismedicalsystem.model.po.Dept;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class DeptService {

    @Resource
    private DeptMapper deptMapper;

    public List<Dept> getAllDepts(){
        return deptMapper.getAllDepts();
    }

}