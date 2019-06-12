package com.neuedu.hismedicalsystem.model.service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.neuedu.hismedicalsystem.model.mapper.BillMapper;
import com.neuedu.hismedicalsystem.model.mapper.DeptMapper;
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
    private DeptMapper deptMapper;

    @Resource
    private ReceiptMapper receiptMapper;

    @Resource
    private BillMapper billMapper;



    public int logReceipt(JSONObject obj){
        System.out.println("logReceipt->obj.toString() = " + obj.toString());
        Patient patientInfo = (Patient) JSONObject.toJavaObject(obj.getJSONObject("patientInfo"), Patient.class);
        System.out.println("logReceipt->patientInfo = " + patientInfo);
        JSONArray array = obj.getJSONArray("bills");
        List<Bill> bills = JSONObject.parseArray(array.toJSONString(), Bill.class);
        System.out.println("logReceipt->bills = " + bills);
        String confirmType = obj.getString("confirmType");
        int chargerid = obj.getInteger("chargerid");

        int recid = insertNewReceipt(bills,chargerid,patientInfo,confirmType);
        updateRecIdForBills(bills,recid);
        return recid;
    }

    private void updateRecIdForBills(List<Bill> bills, int recid){
        for(Bill b : bills){
            billMapper.updateRecid(b.getBillid(), recid);
        }
    }

    private int insertNewReceipt(List<Bill> bills, int chargerid, Patient patientInfo, String confirmType){
        Receipt receipt = new Receipt();
        receipt.setRecstate("未打印");

        Bill firstBill = bills.get(0);

        int billid = firstBill.getBillid();

        receipt.setuRid(billid);

        receipt.setChargerid(chargerid);
        receipt.setTotalprice(getPrintedTotalPrice(bills, confirmType));
        receipt.setPid(patientInfo.getPid());
        receiptMapper.addRec(receipt);
        return receipt.getRecid();
    }

    public double getPrintedTotalPrice(JSONObject obj){
        JSONArray array = obj.getJSONArray("bills");
        List<Bill> bills = JSONObject.parseArray(array.toJSONString(), Bill.class);
        String confirmType = obj.getString("confirmType");
        return getPrintedTotalPrice(bills, confirmType);
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

    public int getURidByBillid(int billid){
        String treatcat = billMapper.getTreatcatByBillid(billid);
        return billMapper.getURidByBillid(billid, treatcat);
    }

    public List<Receipt> getRecsByPid(JSONObject obj){
        long pid = obj.getLong("pid");
        return receiptMapper.getRecsByPid(pid);
    }


    public Receipt getReceiptByRecid(JSONObject obj) {
        int recid = obj.getInteger("recid");
        Receipt receipt = receiptMapper.getReceiptByRecid(recid);
        System.out.println("getReceiptByRecid->receipt = " + receipt);
        return receipt;
    }

    public List<Bill> getBillsByRecid(JSONObject obj){
        int recid = obj.getInteger("recid");
        return billMapper.getBillsByRecid(recid);
    }


    public JSONArray getReceiptInfoForDepartment() {
        int count = 0;
        User doctorCon = new User();
        doctorCon.setUsercat("门诊医生");
        List<User> doctorList = userMapper.getUsers(doctorCon);

        Dept deptCon = new Dept();
        List<Dept> deptList = deptMapper.getDepts(deptCon);

        System.out.println("deptList = " + deptList);
        List<String> feecodes = receiptMapper.getAllFeeCodes();
        System.out.println("feecodes = " + feecodes);

        List<Financial> fList = new ArrayList<>();

        for (Dept dept : deptList) {
            if (count == 5) {
                break;
            }
            Financial f = new Financial();
            f.setUsername(dept.getDeptname());
            //看诊人次
            f.setPatientsamount(receiptMapper.countRegsForDepartment(dept.getuRid()));
            //收据个数
            f.setReceiptamount(receiptMapper.countReceiptsForDepartment(dept.getuRid()));
            {
                f.setFeecode1(receiptMapper.sumFeeCodePriceForDept(dept.getuRid(), "CSCLF"));
                f.setFeecode2(receiptMapper.sumFeeCodePriceForDept(dept.getuRid(), "CSJCF"));
                f.setFeecode3(receiptMapper.sumFeeCodePriceForDept(dept.getuRid(), "CTCLF"));
                f.setFeecode4(receiptMapper.sumFeeCodePriceForDept(dept.getuRid(), "CTJCF"));
                f.setFeecode5(receiptMapper.sumFeeCodePriceForDept(dept.getuRid(), "CZCLF"));
                f.setFeecode6(receiptMapper.sumFeeCodePriceForDept(dept.getuRid(), "CZF"));
                f.setFeecode7(receiptMapper.sumFeeCodePriceForDept(dept.getuRid(), "FSCLF"));
                f.setFeecode8(receiptMapper.sumFeeCodePriceForDept(dept.getuRid(), "FSJCF"));
                f.setFeecode9(receiptMapper.sumFeeCodePriceForDept(dept.getuRid(), "GHF"));
                f.setFeecode10(receiptMapper.sumFeeCodePriceForDept(dept.getuRid(), "JYCLF"));
                f.setFeecode11(receiptMapper.sumFeeCodePriceForDept(dept.getuRid(), "JYF"));
                f.setFeecode12(receiptMapper.sumFeeCodePriceForDept(dept.getuRid(), "MRICLF"));
                f.setFeecode13(receiptMapper.sumFeeCodePriceForDept(dept.getuRid(), "MRIJCF"));
                f.setFeecode14(receiptMapper.sumFeeCodePriceForDept(dept.getuRid(), "MZF"));
                f.setFeecode15(receiptMapper.sumFeeCodePriceForDept(dept.getuRid(), "MZSSF"));
                f.setFeecode16(receiptMapper.sumFeeCodePriceForDept(dept.getuRid(), "MZYF"));
                f.setFeecode17(receiptMapper.sumFeeCodePriceForDept(dept.getuRid(), "QT"));
                f.setFeecode18(receiptMapper.sumFeeCodePriceForDept(dept.getuRid(), "XYF"));
                f.setFeecode19(receiptMapper.sumFeeCodePriceForDept(dept.getuRid(), "ZCHYF"));
                f.setFeecode20(receiptMapper.sumFeeCodePriceForDept(dept.getuRid(), "ZCYF"));
                f.setFeecode21(receiptMapper.sumFeeCodePriceForDept(dept.getuRid(), "ZLF"));
            }
            fList.add(f);
            count++;
        }

        return JSONArray.parseArray(JSON.toJSONString(fList));
    }
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


}
