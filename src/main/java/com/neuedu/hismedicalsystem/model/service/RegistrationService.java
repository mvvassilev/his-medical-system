package com.neuedu.hismedicalsystem.model.service;

import com.neuedu.hismedicalsystem.model.mapper.ShiftMapper;
import com.neuedu.hismedicalsystem.model.mapper.UserMapper;
import com.neuedu.hismedicalsystem.model.po.Shift;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class RegistrationService {
    @Resource
    private UserMapper userMapper;

    @Resource
    private ShiftMapper shiftMapper;

    public void getAvailableDoctorList(String deptcode){
        System.out.println("deptcode"+deptcode);
        List<Shift> availableShifts = shiftMapper.getShiftsAvailable();
        for(Shift shift : availableShifts){
            System.out.println(shift.toString());
        }
//        System.out.println(udList.toString());
    }
}
