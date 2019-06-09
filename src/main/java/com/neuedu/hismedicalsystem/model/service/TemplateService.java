package com.neuedu.hismedicalsystem.model.service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.neuedu.hismedicalsystem.model.mapper.TemplateMapper;
import com.neuedu.hismedicalsystem.model.po.Medicine;
import com.neuedu.hismedicalsystem.model.po.NonMedic;
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

    @Transactional
    public void delTemp(int tempid){
        templateMapper.delTemp(tempid);
    }

    @Transactional
    public void updateTemp(int tempid,String tempname,String tempscope){ templateMapper.updateTemp(tempid,tempname,tempscope);}

    @Transactional
    public void addItem(int tempid, String itemcode){templateMapper.addItem(tempid,itemcode);}

    @Transactional
    public List<Medicine> getDeatils(int tempid){return templateMapper.getDetails(tempid);}

    @Transactional
    public void delDetails(int tempRelid){templateMapper.delDetails(tempRelid);}

    @Transactional
    public JSONArray getItem(String temptype, String itemcode){
        JSONArray datasArray = new JSONArray();
        switch (temptype){
            case "examination": case "test": case "disposal":
                List<NonMedic> nonMedicList = templateMapper.getNonItem(temptype,itemcode);

                 datasArray = JSON.parseArray(JSON.toJSONString(nonMedicList));
                break;
            case "西药": case "中成药": case "中草药":
                List<Medicine> medicList = templateMapper.getMedItem(temptype, itemcode);
                datasArray = JSON.parseArray(JSON.toJSONString(medicList));

        }
        return datasArray;

    }
}
