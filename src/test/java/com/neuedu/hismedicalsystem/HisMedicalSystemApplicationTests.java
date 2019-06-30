package com.neuedu.hismedicalsystem;


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.neuedu.hismedicalsystem.HisMedicalSystemApplication;
import com.neuedu.hismedicalsystem.controller.RegistrationController;
import com.neuedu.hismedicalsystem.model.service.RegistrationService;
import com.neuedu.hismedicalsystem.model.util.RedisPoolUtil;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockServletContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.context.WebApplicationContext;
import redis.clients.jedis.Jedis;

import java.util.Map;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = { HisMedicalSystemApplication.class, MockServletContext.class })
public class HisMedicalSystemApplicationTests {

	@Autowired
	private WebApplicationContext context;
	private MockMvc mockMvc;

	@Before
	public void setUp() {
		RegistrationController apiController = new RegistrationController();
		mockMvc = MockMvcBuilders.webAppContextSetup(this.context).build();
	}

	@Test
	public void testGetSequence() {
		try {
			String jsonStr = "{\"dept\":\"CK\",\"date\":\"2019-06-02\",\"aorp\":\"true\",\"registrationLevel\":\"专家号\"}";
			JSONObject jsonObject = JSONObject.parseObject(jsonStr);
			String responseString = mockMvc.perform(post("/registration/getDoctorsAvailable").contentType(MediaType.APPLICATION_JSON).content(jsonStr)).andDo(print())
					.andExpect(status().isOk()).andReturn().getResponse().getContentAsString();
			after(responseString);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	public void submitRegistration() {
		try {
			String jsonStr = "{\"dept\":\"CK\",\"date\":\"2019-06-02\",\"aorp\":\"true\",\"registrationLevel\":\"专家号\"}";
			JSONObject jsonObject = JSONObject.parseObject(jsonStr);
			String responseString = mockMvc.perform(post("/registration/submitRegistration").contentType(MediaType.APPLICATION_JSON).content(jsonStr)).andDo(print())
					.andExpect(status().isOk()).andReturn().getResponse().getContentAsString();
			after(responseString);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	public void getRegistrationPrice() {
		try {
			String jsonStr = "{\"dept\":\"CK\",\"date\":\"2019-06-02\",\"aorp\":\"true\",\"registrationLevel\":\"专家号\"}";
			JSONObject jsonObject = JSONObject.parseObject(jsonStr);
			String responseString = mockMvc.perform(post("/registration/getRegistrationPrice").contentType(MediaType.APPLICATION_JSON).content(jsonStr)).andDo(print())
					.andExpect(status().isOk()).andReturn().getResponse().getContentAsString();
			after(responseString);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	public void getPatientInfo() {
		try {
			String jsonStr = "{\"dept\":\"CK\",\"date\":\"2019-06-02\",\"aorp\":\"true\",\"registrationLevel\":\"专家号\"}";
			JSONObject jsonObject = JSONObject.parseObject(jsonStr);
			String responseString = mockMvc.perform(post("/registration/tryCompletePatientInfo").contentType(MediaType.APPLICATION_JSON).content(jsonStr)).andDo(print())
					.andExpect(status().isOk()).andReturn().getResponse().getContentAsString();
			after(responseString);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	public void getRegById() {
		try {
			String jsonStr = "{\"dept\":\"CK\",\"date\":\"2019-06-02\",\"aorp\":\"true\",\"registrationLevel\":\"专家号\"}";
			JSONObject jsonObject = JSONObject.parseObject(jsonStr);
			String responseString = mockMvc.perform(post("/registration/getRegistrations").contentType(MediaType.APPLICATION_JSON).content(jsonStr)).andDo(print())
					.andExpect(status().isOk()).andReturn().getResponse().getContentAsString();
			after(responseString);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

    @Test
    public void getPatientsOfUserToday() {
        try {
            String jsonStr = "{\"state\":\"已挂号\",\"userid\":\"13215\"}";
            JSONObject jsonObject = JSONObject.parseObject(jsonStr);
            String responseString = mockMvc.perform(post("/outpatient/getPatientsOfUserToday").contentType(MediaType.APPLICATION_JSON).content(jsonStr)).andDo(print())
                    .andExpect(status().isOk()).andReturn().getResponse().getContentAsString();
            after(responseString);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void getPatientsOfDeptToday() {
        try {
            String jsonStr = "{\"state\":\"已挂号\",\"deptcode\":\"CK\"}";
            JSONObject jsonObject = JSONObject.parseObject(jsonStr);
            String responseString = mockMvc.perform(post("/outpatient/getPatientsOfDeptToday").contentType(MediaType.APPLICATION_JSON).content(jsonStr)).andDo(print())
                    .andExpect(status().isOk()).andReturn().getResponse().getContentAsString();
            after(responseString);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

	@Test
	public void testSelectKey() {

		try {
			String jsonStr = "{\"state\":\"已挂号\",\"deptcode\":\"CK\"}";
			JSONObject jsonObject = JSONObject.parseObject(jsonStr);
			String responseString = mockMvc.perform(post("/registration/test").contentType(MediaType.APPLICATION_JSON).content(jsonStr)).andDo(print())
					.andExpect(status().isOk()).andReturn().getResponse().getContentAsString();
			after(responseString);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	public void testAPIforFinancial(){
		try {
			String jsonStr = "{\"state\":\"已挂号\",\"deptcode\":\"CK\"}";
			JSONObject jsonObject = JSONObject.parseObject(jsonStr);
			String responseString = mockMvc.perform(post("/financial/testAPI").contentType(MediaType.APPLICATION_JSON).content(jsonStr)).andDo(print())
					.andExpect(status().isOk()).andReturn().getResponse().getContentAsString();
			after(responseString);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	public void testKEVIN() {

		try {
			String jsonStr = "{\"billid\":2}";
			JSONObject jsonObject = JSONObject.parseObject(jsonStr);
			String responseString = mockMvc.perform(post("/charge/getURidByBillid").contentType(MediaType.APPLICATION_JSON).content(jsonStr)).andDo(print())
					.andExpect(status().isOk()).andReturn().getResponse().getContentAsString();
			after(responseString);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void after(String responseString){
		System.out.println("接口返回结果：" + responseString);
		JSONObject resultObj = JSON.parseObject(responseString);
		// 判断接口返回json中success字段是否为true
		Assert.assertTrue(resultObj.getBooleanValue("success"));
	}

	@Test
	public void testRedis() {
		Jedis jedis = RedisPoolUtil.getJedis();
		String key = "Hey";
		if(jedis.exists(key)){
			System.out.println("Searched from Redis: " + jedis.get(key));
		}
		else{
			System.out.println("Nah");
		}
		RedisPoolUtil.close(jedis);
	}

	@Test
	public void testRedisHash() {
		Jedis jedis = RedisPoolUtil.getJedis();
		String key = "users";
		if(jedis.exists(key)){
			Map<String, String> map = jedis.hgetAll(key);
			System.out.println("Searched from Redis: " +
					map.get("id") + "\t" +
					map.get("name") + "\t" +
					map.get("age") + "\t" +
					map.get("remark")
			);
		}
		else{
			System.out.println("Monitor a process of loading from database into Redis");
			String id = "1";
			jedis.hset(key, "id", id);
			jedis.hset(key, "name", "Max");
			jedis.hset(key, "age", "21");
			jedis.hset(key, "remark", "He really needs love.");
		}
		RedisPoolUtil.close(jedis);
	}




}