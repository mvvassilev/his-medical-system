package com.neuedu.hismedicalsystem.model.service;

import com.neuedu.hismedicalsystem.model.mapper.BillCategoryMapper;
import com.neuedu.hismedicalsystem.model.po.BillCategory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class BillCategoryService {
    @Resource
    private BillCategoryMapper billCategoryMapper;

    public void test(){
        System.out.println(billCategoryMapper);
    }

    public List<BillCategory> getBillCategories(BillCategory condition){
        return billCategoryMapper.getBillCategories(condition);
    }
}