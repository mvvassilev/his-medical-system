package com.neuedu.hismedicalsystem.model.service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.neuedu.hismedicalsystem.model.mapper.ReceiptMapper;
import com.neuedu.hismedicalsystem.model.mapper.UserMapper;
import com.neuedu.hismedicalsystem.model.po.*;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Service
public class ReceiptService {
    @Resource
    private UserMapper userMapper;
    
    @Resource
    private ReceiptMapper receiptMapper;


    public JSONArray getReceiptInfoForDoctor(){
        User doctorCon = new User();
        doctorCon.setUsercat("门诊医生");
        List<User> doctorList = userMapper.getUsers(doctorCon);

        System.out.println("doctorList = " + doctorList);
        List<String> feecodes = receiptMapper.getAllFeeCodes();
        System.out.println("feecodes = " + feecodes);

        List<Financial> fList = new ArrayList<>();
        for(User doc : doctorList){
//            System.out.println("Loop doc = " + doc);
            System.out.println("doc.getUserid() = " + doc.getUserid());
            for(Dept dept : doc.getDepts()) {
                Financial f = new Financial();
                f.setUsername(doc.getUsername()+"-"+dept.getDeptname());
                //看诊人次
                f.setPatientsamount(receiptMapper.countRegsForDoctor(dept.getuRid()));
                //收据个数
                f.setReceiptamount(receiptMapper.countReceiptsForDoctor(dept.getuRid()));
                {
                    f.setFeecode1(receiptMapper.sumFeeCodePriceForDoc(dept.getuRid(), "CSCLF"));
                    f.setFeecode2(receiptMapper.sumFeeCodePriceForDoc(dept.getuRid(), "CSJCF"));
                    f.setFeecode3(receiptMapper.sumFeeCodePriceForDoc(dept.getuRid(), "CTCLF"));
                    f.setFeecode4(receiptMapper.sumFeeCodePriceForDoc(dept.getuRid(), "CTJCF"));
                    f.setFeecode5(receiptMapper.sumFeeCodePriceForDoc(dept.getuRid(), "CZCLF"));
                    f.setFeecode6(receiptMapper.sumFeeCodePriceForDoc(dept.getuRid(), "CZF"));
                    f.setFeecode7(receiptMapper.sumFeeCodePriceForDoc(dept.getuRid(), "FSCLF"));
                    f.setFeecode8(receiptMapper.sumFeeCodePriceForDoc(dept.getuRid(), "FSJCF"));
                    f.setFeecode9(receiptMapper.sumFeeCodePriceForDoc(dept.getuRid(), "GHF"));
                    f.setFeecode10(receiptMapper.sumFeeCodePriceForDoc(dept.getuRid(), "JYCLF"));
                    f.setFeecode11(receiptMapper.sumFeeCodePriceForDoc(dept.getuRid(), "JYF"));
                    f.setFeecode12(receiptMapper.sumFeeCodePriceForDoc(dept.getuRid(), "MRICLF"));
                    f.setFeecode13(receiptMapper.sumFeeCodePriceForDoc(dept.getuRid(), "MRIJCF"));
                    f.setFeecode14(receiptMapper.sumFeeCodePriceForDoc(dept.getuRid(), "MZF"));
                    f.setFeecode15(receiptMapper.sumFeeCodePriceForDoc(dept.getuRid(), "MZSSF"));
                    f.setFeecode16(receiptMapper.sumFeeCodePriceForDoc(dept.getuRid(), "MZYF"));
                    f.setFeecode17(receiptMapper.sumFeeCodePriceForDoc(dept.getuRid(), "QT"));
                    f.setFeecode18(receiptMapper.sumFeeCodePriceForDoc(dept.getuRid(), "XYF"));
                    f.setFeecode19(receiptMapper.sumFeeCodePriceForDoc(dept.getuRid(), "ZCHYF"));
                    f.setFeecode20(receiptMapper.sumFeeCodePriceForDoc(dept.getuRid(), "ZCYF"));
                    f.setFeecode21(receiptMapper.sumFeeCodePriceForDoc(dept.getuRid(), "ZLF"));
                }
                fList.add(f);
            }
        }
        return JSONArray.parseArray(JSON.toJSONString(fList));

//        System.out.println("*-*-*-*-*-*-*-*-*-*-");
//        for(Financial f : fList){
//            System.out.print(f.getFeecode13()+" ");
//        }
    }

    public void logReceipt(JSONObject obj){
        Patient patientInfo = (Patient) JSONObject.toJavaObject(obj.getJSONObject("patientInfo"), Patient.class);
        JSONArray array = obj.getJSONArray("bills");
        List<Bill> bills = JSONObject.parseArray(array.toJSONString(), Bill.class);
        String confirmType = obj.getString("confirmType");
        long chargerid = obj.getLong("chargerid");
        insertNewReceipt(bills,chargerid,patientInfo,confirmType);
    }

    private void insertNewReceipt(List<Bill> bills, long chargerid, Patient patientInfo, String confirmType){
        Receipt receipt = new Receipt();
        receipt.setRecstate("未打印");
        receipt.setChargerid(chargerid);
        receipt.setTotalprice(getPrintedTotalPrice(bills, confirmType));
        receipt.setPid(patientInfo.getPid());

    }

    private double getPrintedTotalPrice(List<Bill> bills, String confirmType){
        double value = 0;
        for(Bill b : bills){
            double add = b.getTotalprice();
            if(confirmType.equals("Refund")){
                if( add > 0 )
                    add = -add;
            }
            value += add;
        }
        return value;
    }
}
