package com.neuedu.hismedicalsystem.model.mapper;

import com.neuedu.hismedicalsystem.model.po.Shift;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;

public interface ShiftMapper {
    public List<Shift> getShift(@Param("dates") Date dates, @Param("datee") Date datee);
}
