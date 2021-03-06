package com.neuedu.hismedicalsystem.model.mapper;


import com.neuedu.hismedicalsystem.model.po.Registration;

import java.util.List;

public interface RegistrationMapper {

    int addRegister(Registration registration);

    int getCurrentOrder(int shiftid);

    int countRegsInShift(int shiftid);

    List<Registration> getRegistrationsByPid(int pid);

    List<Registration> getCancellableRegistrationsByPid(int pid);

    void delReg(int regid);

}
