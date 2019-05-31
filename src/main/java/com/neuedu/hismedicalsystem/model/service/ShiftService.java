package com.neuedu.hismedicalsystem.model.service;

import com.neuedu.hismedicalsystem.model.mapper.ShiftMapper;
import com.neuedu.hismedicalsystem.model.po.Shift;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

@Service
public class ShiftService {
    @Resource
    private ShiftMapper shiftMapper;

    public List<Shift> getShift(Date dates, Date datee) {
        return shiftMapper.getShift(dates, datee);
    }

    @Transactional
    public void delShift(int shiftid) {
        shiftMapper.delShift(shiftid);
    }

    @Transactional
    public void delAllShift(String[] id){shiftMapper.delAllShift(id);}

    public void updateShift(List<Shift> updateshifts) { shiftMapper.updateShift(updateshifts);
    }

    public void insertShift(List<Shift> insertShifts) { shiftMapper.insertShift(insertShifts);
    }

    public void deleteConflictShifts(Date startdate, Date enddate) { shiftMapper.deleteConflictShifts(startdate,enddate);
    }
}
