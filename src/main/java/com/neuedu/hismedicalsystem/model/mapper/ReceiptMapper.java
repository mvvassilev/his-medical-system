package com.neuedu.hismedicalsystem.model.mapper;

import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ReceiptMapper {
    List<String> getAllFeeCodes();
    int countRegsForDoctor(int uRid);
    int countReceiptsForDoctor(int uRid);
    double sumFeeCodePriceForDoc( @Param("uRid") int uRid, @Param("feecode") String feecode);
}
