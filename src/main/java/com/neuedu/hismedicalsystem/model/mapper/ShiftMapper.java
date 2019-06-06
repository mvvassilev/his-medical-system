package com.neuedu.hismedicalsystem.model.mapper;

import com.neuedu.hismedicalsystem.model.po.Shift;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;

public interface ShiftMapper {
    public List<Shift> getShift(@Param("dates") Date dates, @Param("datee") Date datee);

    //TODO: Here I omitted the date condition (The shifts to register have to be in today) for testing purpose.
    //For Registration Getting Available Doctors
    public List<Shift> getShiftsAvailable(@Param("aorp") boolean aorp,
                                          @Param("deptcode") String deptcode, @Param("itemname") String itemname);

    void updateShift(List<Shift> updateshifts);

    void insertShift(List<Shift> insertShifts);

    void deleteConflictShifts(@Param("startdate") Date startdate, @Param("enddate") Date enddate);

    public void delShift(int shiftid);

    public void delAllShift(String[] id);

    public void deductOneBalance(int shiftid);
}
