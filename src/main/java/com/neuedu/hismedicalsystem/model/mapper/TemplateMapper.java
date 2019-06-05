package com.neuedu.hismedicalsystem.model.mapper;

import com.neuedu.hismedicalsystem.model.po.Template_all;

import java.util.List;

public interface TemplateMapper {
    public List<Template_all> getTemp(Template_all condition);

    public void addTemp(Template_all template_all);

    public void delTemp(int tempid);
}
