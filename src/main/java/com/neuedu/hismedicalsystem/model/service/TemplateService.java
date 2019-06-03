package com.neuedu.hismedicalsystem.model.service;

import com.neuedu.hismedicalsystem.model.mapper.TemplateMapper;
import com.neuedu.hismedicalsystem.model.po.Template_all;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Service
public class TemplateService {
    @Resource
    private TemplateMapper templateMapper;

    public List<Template_all> getTemp(Template_all condition) {
        return templateMapper.getTemp(condition);
    }

    @Transactional
    public void addTemp(Template_all template_all) throws Exception {
        templateMapper.addTemp(template_all);
    }
}
