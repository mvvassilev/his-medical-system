package com.neuedu.hismedicalsystem.model.mapper;

import com.neuedu.hismedicalsystem.model.po.Template_all;

import java.util.List;

public interface TemplateMapper {
    public List<Template_all> getTemp(Template_all condition);
}
