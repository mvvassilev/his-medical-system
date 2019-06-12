package com.neuedu.hismedicalsystem.model.service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.neuedu.hismedicalsystem.model.mapper.DeptMapper;
import com.neuedu.hismedicalsystem.model.mapper.ReceiptMapper;
import com.neuedu.hismedicalsystem.model.mapper.UserMapper;
import com.neuedu.hismedicalsystem.model.po.Dept;
import com.neuedu.hismedicalsystem.model.po.Financial;
import com.neuedu.hismedicalsystem.model.po.User;
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
    
}
