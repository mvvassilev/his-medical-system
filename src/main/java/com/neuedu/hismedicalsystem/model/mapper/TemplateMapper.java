package com.neuedu.hismedicalsystem.model.mapper;

import com.neuedu.hismedicalsystem.model.po.Medicine;
import com.neuedu.hismedicalsystem.model.po.NonMedic;
import com.neuedu.hismedicalsystem.model.po.Template_all;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TemplateMapper {
    public List<Template_all> getTemp(Template_all condition);

    public void addTemp(Template_all template_all);

    public void delTemp(int tempid);

    public List<Medicine> getMedItem(@Param("temptype") String temptype);

    public List<NonMedic> getNonItem(@Param("temptype") String temptype);
}
