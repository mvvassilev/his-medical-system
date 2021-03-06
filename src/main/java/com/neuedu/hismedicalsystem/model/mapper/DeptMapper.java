package com.neuedu.hismedicalsystem.model.mapper;

import com.neuedu.hismedicalsystem.model.po.Dept;

import java.util.List;

public interface DeptMapper {
    public List<Dept> getDepts(Dept condition);

    public void delDept(String deptcode);

    public void addDept(Dept dept);

    public void updateDept(Dept dept);

    List<Dept> getDeptSelect();
}
