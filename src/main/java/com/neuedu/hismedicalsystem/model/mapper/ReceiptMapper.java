package com.neuedu.hismedicalsystem.model.mapper;

import com.neuedu.hismedicalsystem.model.po.Receipt;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ReceiptMapper {
    List<String> getAllFeeCodes();
    int countRegsForDoctor(int uRid);
    int countReceiptsForDoctor(int uRid);
    double sumFeeCodePriceForDoc( @Param("uRid") int uRid, @Param("feecode") String feecode);
    void addRec(Receipt receipt);
    List<Receipt> getRecsByPid(long pid);

    List<Receipt> getReceiptByRecid(int recid);
}
