package com.example.springboot_thymeleaf.service;

import com.example.springboot_thymeleaf.model.User;

import java.util.List;

public interface UserService {
    //ID找個人
    User getUserById(int user_id);

    //查找所有人
    List<User> getAllUser();

    //通過id刪除個人
    int deleteById(int user_id);

    //更新個人信息
    int updateById(int user_id,String user_account,String user_pwd,String user_name);

    //根據賬號查找個人
    User getUserById(String user_account);

    //插入數據
    int insertUser(String user_name,String user_account,String user_pwd);

    int getIntUser();
}
