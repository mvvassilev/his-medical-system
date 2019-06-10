package com.neuedu.hismedicalsystem.model.mapper;

import com.neuedu.hismedicalsystem.model.po.Prescription;

import java.util.List;

public interface PrescriptionMapper {
    public List<Prescription> getPre(Prescription condition);
}
