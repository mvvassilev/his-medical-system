package com.neuedu.hismedicalsystem.model.mapper;

import com.neuedu.hismedicalsystem.model.po.BillCategory;

import java.util.List;

public interface BillCategoryMapper {
    public List<BillCategory> getBillCategories(BillCategory condition);
}
