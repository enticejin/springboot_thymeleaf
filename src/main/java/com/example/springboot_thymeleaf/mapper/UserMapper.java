package com.example.springboot_thymeleaf.mapper;

import com.example.springboot_thymeleaf.model.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface UserMapper {
    //通过id查找个人信息
    @Select("select * from test01 where user_id = #{user_id}")
    User getUserById(@Param("user_id") int user_id);

    //通过账号查找个人信息
    @Select("select * from test01 where user_account = #{user_account}")
    User getUserByAccount(@Param("user_account") String user_account);

    //新增人员信息
    @Insert("insert into test01 (user_account,user_pwd,user_name) values (#{user_account},#{user_pwd},#{user_name})")
    int insertUser(@Param("user_account") String user_account,@Param("user_pwd") String user_pwd,@Param("user_name") String user_name);

    //查詢所有人員信息
    @Select("select * from test01")
    List<User> getAllUser();

    //通過id修改個人信息
    @Update("update test01 set user_account=#{user_account},user_pwd = #{user_pwd},user_name = #{user_name} where user_id = #{user_id}")
    int updateById(@Param("user_id") int user_id,@Param("user_account") String user_account,@Param("user_pwd") String user_pwd,@Param("user_name") String user_name);

    //通過id刪除個人信息
    @Delete("delete from test01 where user_id = #{user_id}")
    int deleteById(@Param("user_id") int user_id);
}
