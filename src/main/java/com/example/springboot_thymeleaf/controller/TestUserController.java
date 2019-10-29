package com.example.springboot_thymeleaf.controller;

import com.example.springboot_thymeleaf.model.User;
import com.example.springboot_thymeleaf.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import java.util.List;

@Controller
@RequestMapping(value = "/test")
public class TestUserController {

    private  final Logger logger = LoggerFactory.getLogger(TestUserController.class);

    @Autowired
    private UserService userService;
    @RequestMapping("/num")
    @ResponseBody
    int home(){
        int num = userService.getIntUser();
        return num;
    }

    @RequestMapping("/getUser")
    @ResponseBody
    List<User> getUser(){
        //打印日誌
        logger.info("TestController getUser info");
        return (List<User>) userService.getAllUser();
    }

}
