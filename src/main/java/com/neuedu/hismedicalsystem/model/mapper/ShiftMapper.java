package com.neuedu.hismedicalsystem.model.mapper;

import com.neuedu.hismedicalsystem.model.po.Shift;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;

public interface ShiftMapper {
    public List<Shift> getShift(@Param("dates") Date dates, @Param("datee") Date datee);

    void updateShift(List<Shift> updateshifts);

    void insertShift(List<Shift> insertShifts);

    void deleteConflictShifts(@Param("startdate") Date startdate, @Param("enddate") Date enddate);
}
