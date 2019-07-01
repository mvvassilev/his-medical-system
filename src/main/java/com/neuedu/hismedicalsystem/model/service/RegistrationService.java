package com.neuedu.hismedicalsystem.model.service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.neuedu.hismedicalsystem.model.mapper.*;
import com.neuedu.hismedicalsystem.model.po.*;
import com.neuedu.hismedicalsystem.model.util.RedisPoolUtil;
import org.springframework.stereotype.Service;
import redis.clients.jedis.Jedis;

import javax.annotation.Resource;
import java.util.List;

@Service
public class RegistrationService {
    @Resource
    private UserMapper userMapper;

    @Resource
    private ShiftMapper shiftMapper;

    @Resource
    private PatientMapper patientMapper;

    @Resource
    private BillMapper billMapper;

    @Resource
    private RegistrationMapper registrationMapper;

    public List<Shift> getAvailableDoctorList(boolean aorp, String deptcode, String itemname){
        List<Shift> availableShifts = shiftMapper.getShiftsAvailable(aorp,deptcode,itemname);
        return availableShifts;
    }

    //For registering a new patient
    public void insertPatient(Patient patient) {
        System.out.println("insertPatient = " + patient);
        patient.setState("已挂号");
        patientMapper.insertPatient(patient);
    }

    //add a new registration to the bill table
    public Bill addRegistrationBill(Patient patient, NonMedic registration, boolean newrecord, String billcat) {
        Bill bill = new Bill();
        double price = registration.getPrice();
        double newrecordPrice = 1;
        if(newrecord)//if new record is required we add 1
            bill.setTotalprice(price + newrecordPrice);
        else
            bill.setTotalprice(price);
        bill.setPid(patient.getPid());
        bill.setCount(1);
        bill.setPaid(true);
        bill.setItemcode(registration.getItemcode());
        bill.setFeecode(registration.getFeecode());
        bill.setDone(true);
        bill.setBillcat(billcat);
        billMapper.insertBill(bill);

        return bill;
    }

    public void registerToShift(Patient patient, NonMedic registrationType, boolean newrecord, Shift shift) {
        Registration register = new Registration();
        register.setNewRecord(newrecord);

        //Get the current order for the patient ( maximum in shift +1 )
        int shiftid = shift.getShiftid();
        int currentOrder = getOrderInShift(shiftid);
        register.setOrder(currentOrder);

        register.setPid(patient.getPid());
        register.setuRid(shift.getuRid());
        register.setItemcode(registrationType.getItemcode());
        register.setShiftid(shiftid);

        registrationMapper.addRegister(register);
        //Deduct one in balance field for the shift
        shiftMapper.deductOneBalance(shiftid);
        //Create Homepage For this registration
        patientMapper.insertHomepage(register.getRegid());
    }


    /**
     *
     * @param shiftId 医生门诊排班的ID
     * @return 返回一个当前号的整型数
     * 注意下需要更改ReidsPoolUtil中的配置'String host = "自己redis的ip地址";'
     */
    private int getOrderInShift(int shiftId){
        //set up redis connection
        Jedis jedis = RedisPoolUtil.getJedis();
        String key = "shift_order_" + (Integer)shiftId;
        //examine if exists
        //If yes return auto-incremented order
        if(jedis.exists(key)) {
            jedis.incr(key);
            return Integer.parseInt(jedis.get(key));
        }else{//Else, create the key and set the initial order with 0
            jedis.set(key, "1");
            return 1;
        }
    }

    public JSONObject getPatientInfo(int id) {
        Patient p;
        JSONObject result = new JSONObject();
        if(patientMapper.countPatientOfId(id)==1){
            p = patientMapper.getPatientById(id);
            int regSize= registrationMapper.getRegistrationsByPid(id).size();
            if(regSize >= 1){
                Registration reg = registrationMapper.getRegistrationsByPid(id).get(0);
                System.out.println("reg = " + reg);
                if(reg.getState()==6)
                    result.put("lastRegFinished",true);
                else
                    result.put("lastRegFinished",false);
            }
            result.put("patient",(JSONObject) JSON.toJSON(p));
            result.put("exists","Yes");
        }
        else{
            p =  new Patient();
            result.put("patient",(JSONObject) JSON.toJSON(p));
            result.put("exists","No");
            result.put("lastRegFinished",true);
        }
        return result;
    }

    public List<Registration> getCancellableRegistrationsByPid(int id){
        return registrationMapper.getCancellableRegistrationsByPid(id);
    }

    public void deleteRegs(List<Registration> regs){
        for(Registration reg : regs){
            registrationMapper.delReg(reg.getRegid());
        }
    }
}
