package com.example.springboot_thymeleaf.controller;

import com.example.springboot_thymeleaf.model.User;
import com.example.springboot_thymeleaf.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/form")
    public String form(Model model){
        model.addAttribute("user",new User());
        return "/user/form";
    }

    @GetMapping("{user_id}")
    public String userview(@PathVariable("user_id") int user_id,Model model){
        User user = userService.getUserById(user_id);
        model.addAttribute("user",user);
        return "/user/userview";
    }

    @PostMapping
    public String saveUser(User user){
        System.out.println("新建用戶的 user_id 是："+user.getUser_id());
        System.out.println("新建用戶的 user_pwd 是："+user.getUser_pwd());
        System.out.println("新建用戶的 user_account 是："+user.getUser_account());
        System.out.println("新建用戶的 user_name 是："+user.getUser_name());
        if(user.getUser_id() == null){
                userService.insertUser(user.getUser_name(),user.getUser_account(),user.getUser_pwd());
        }else{
            int num = userService.updateById(user.getUser_id(),user.getUser_account(),user.getUser_pwd(),user.getUser_name());
        }
        return "/user/common/success";
    }

    @GetMapping(value = "edit/{user_id}")
    public String editForm(@PathVariable("user_id") int user_id,Model model){
        User user = userService.getUserById(user_id);
        model.addAttribute("user",user);
        return "/user/form";
    }

    @GetMapping(value = "delete/{user_id}")
    public String delete(@PathVariable("user_id") int user_id){
        System.out.println(user_id);
        userService.deleteById(user_id);
        return "/user/common/success";
    }

    @GetMapping("/userList")
    public String userList(Model model){
        System.out.println(userService.getAllUser());
        model.addAttribute("userList",userService.getAllUser());
        return "/user/userList";
    }
}
