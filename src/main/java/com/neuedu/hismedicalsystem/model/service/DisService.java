package com.neuedu.hismedicalsystem.model.service;

import com.neuedu.hismedicalsystem.model.mapper.DisMapper;
import com.neuedu.hismedicalsystem.model.po.Disease;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Service
public class DisService {
    @Resource
    private DisMapper disMapper;

    public List<Disease> getDis(Disease condition) {
        return disMapper.getDis(condition);
    }

    @Transactional
    public void addDis(Disease disease) throws Exception {
        disMapper.addDis(disease);
    }

    @Transactional
    public void delDis(String icdcode) {
        disMapper.delDis(icdcode);
    }

    @Transactional
    public void updateDis(Disease disease) {
        disMapper.updateDis(disease);
    }
}
