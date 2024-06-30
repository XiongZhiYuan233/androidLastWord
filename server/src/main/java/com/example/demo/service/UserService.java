package com.example.demo.service;

import com.auth0.jwt.JWTVerifier;
import com.example.demo.pojo.User;
import com.example.demo.pojo.Userdata;
import org.springframework.stereotype.Repository;

import java.sql.Blob;
import java.util.List;

@Repository
public interface UserService {
    List<Userdata> findALLUser();//    返回数据库中所有用户数据


    Integer judgeUser(String user_email,String user_password);//     判断用户是否在数据库中，如果是则返回一个User，实际返回一个1或0

    String getToken(String user_email,String user_password);

    Boolean addUser(User user);

    Boolean verify(String token);//验证成功返回一个jwtverrifier对象，否则为空

    Boolean deleteUser_Data(String user_email);


    Integer judgeUserData(String user_email);
    Userdata getUserdata(String user_email);
    Boolean addUserDataIn(Userdata userdata);

    Boolean updateUserdata(Userdata userdata);
}

