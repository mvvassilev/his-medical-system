package com.neuedu.hismedicalsystem.controller;

import com.neuedu.hismedicalsystem.model.po.Template_all;
import com.neuedu.hismedicalsystem.model.service.TemplateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/outpatient")
public class OutpatientController {
    /**
     * template
     */
    @Autowired
    private TemplateService templateService;

    @RequestMapping("/temps")
    public List<Template_all> getTemp(@RequestBody Template_all condition) {return templateService.getTemp(condition);}
}
