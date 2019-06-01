package com.neuedu.hismedicalsystem.controller;

import com.alibaba.fastjson.JSONObject;
import com.neuedu.hismedicalsystem.model.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/registration")
public class RegistrationController {
    @Autowired
    private UserService userService;

    @RequestMapping("/getDoctorsAvailable")
    public String getDoctorsAvailable(@RequestBody JSONObject obj) {
        //Date
        //AM or PM
        //Department it belongs

        System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n"+"Hello Son of The One True King");
        System.out.println(obj.getString("msg"));
        return "{\"success\":\"true\"}";
    }
}
