package com.example.demo.mapper;

import com.example.demo.pojo.User;
import com.example.demo.pojo.Userdata;
import jdk.jfr.Unsigned;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.web.bind.annotation.RequestParam;

import java.sql.Blob;
import java.util.List;

@Mapper
public interface UserMapper {
    List<Userdata> findALLUser();

    //加上密码确认
    //返回user_id
    User judgeUser(@Param("user_email") String user_email,@Param("password_hash") String password_hash);
    Userdata getData(@Param("user_email") String user_email);

    Integer insertUser(User user);

    Integer deleteUser(@Param("user_email") String user_email);



    Userdata judgeUserData(@Param("user_email") String user_email);
    Integer insertData(Userdata userdata);
    Boolean updateUserdata(Userdata userdata);
    Integer deleteUserData(@Param("user_email") String user_email);

}
