package com.neuedu.hismedicalsystem.model.mapper;


import com.neuedu.hismedicalsystem.model.po.Registration;

public interface RegistrationMapper {

    void addRegister(Registration registration);

    int getCurrentOrder(int shiftid);

    int countRegsInShift(int shiftid);

}
