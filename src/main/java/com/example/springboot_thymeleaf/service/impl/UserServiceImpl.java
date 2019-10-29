package com.example.springboot_thymeleaf.service.impl;

import com.example.springboot_thymeleaf.mapper.UserMapper;
import com.example.springboot_thymeleaf.model.User;
import com.example.springboot_thymeleaf.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private final Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

    @Autowired
    private UserMapper userMapper;

    @Override
    public User getUserById(int user_id) {
        return userMapper.getUserById(user_id);
    }

    @Override
    public List<User> getAllUser() {
        return userMapper.getAllUser();
    }

    @Override
    public int deleteById(int user_id) {
        return userMapper.deleteById(user_id);
    }

    @Override
    public int updateById(int user_id, String user_account, String user_pwd, String user_name) {
        return userMapper.updateById(user_id,user_account,user_pwd,user_name);
    }


    @Override
    public User getUserById(String user_account) {
        return userMapper.getUserByAccount(user_account);
    }

    @Override
    public int insertUser(String user_name, String user_account, String user_pwd) {
        return userMapper.insertUser(user_account,user_pwd,user_name);
    }

    @Override
    public int getIntUser() {
        return 0;
    }
}
