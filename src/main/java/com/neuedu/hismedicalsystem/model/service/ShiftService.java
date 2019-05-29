package com.neuedu.hismedicalsystem.model.service;

import com.neuedu.hismedicalsystem.model.mapper.ShiftMapper;
import com.neuedu.hismedicalsystem.model.po.Shift;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

@Service
public class ShiftService {
    @Resource
    private ShiftMapper shiftMapper;

    public List<Shift> getShift(Date dates, Date datee){
        return shiftMapper.getShift(dates,datee);
    }
}
