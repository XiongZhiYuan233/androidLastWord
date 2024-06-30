package com.example.demo.service.Impl;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.example.demo.mapper.UserMapper;
import com.example.demo.pojo.User;
import com.example.demo.pojo.Userdata;
import com.example.demo.service.UserService;
import jdk.jfr.Unsigned;
import org.apache.tomcat.Jar;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.sound.midi.Track;
import java.sql.Blob;
import java.util.*;

@Service
public class UserServiceImpl implements UserService {
    //过期时间
    private static final long EXPIRE_DATE = 30*60*100000;
    //token密钥
    private static final String TOKEN_SECRET = "MIIBOQIBAAJBALhT0iVfjXxvQydXdgCYhHyYxS5gVXbq4fQDfbxSsXfT/6dNPc5y rOnmShd8OLqFg2XbVf1jfDc11FpY2UWjscsCAwEAAQJANtV4pnWOeX3/1CxIhlTY 1Nf9kJZH1mB5Z0XCmctfz+1WgtDXHXSY3g1qZvMQkk9Mz2v5BYVJQv0LBkrocnzv AQIhAPrWrXXfqQ7Kl8HsnzXll08eX2ShbShqDGGQFcfZb8HxAiEAvB7Jq2He2/XV 7of36NCFKygreIkMt+hkMiRrbDe2s3sCIEyjAFYuImGxhhIqsC3wWn1Cw1RkeYxK ckPwmKb5iMqRAiAgpUMgD6rqBv5qF4RpDY6ej6kDkNz5KUYCAZn2vLBi8wIgZyoC 85S72Ugx8nYOu8x+tCGVtu8PZ2rBvGzpXCvBZZ4=";

    @Autowired
    private UserMapper userMapper;
    @Override
    public List<Userdata> findALLUser(){
        List<Userdata> allUser = userMapper.findALLUser();
        return allUser;
    }
    @Override
//    需要优化，目前是用户存在就跳转页面
//    优化需要用token，携带用户信息
//      没有验证密码是否正确
    public Integer judgeUser(String user_email,String password_hash){
        User user = userMapper.judgeUser(user_email,password_hash);
//        System.out.println(user_id);
        if(user != null)
            return 1;
        return 0;
    }
    @Override
    public String getToken(String user_email, String password_hash){
        String token = "";
        try {
            //过期时间
            Date data = new Date(System.currentTimeMillis() + EXPIRE_DATE);
            Algorithm algorithm = Algorithm.HMAC256(TOKEN_SECRET);
            //设置头部信息，声明加密方式和加密算法
            Map<String, Object>header = new HashMap<>();
            header.put("typ","JWT");
            header.put("alg","HS256");
            //携带信息生成签名
            token = JWT.create()
                    .withHeader(header)
                    .withClaim("user_email",user_email)
                    .withClaim("password_hash",password_hash)
                    .sign(algorithm);
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
        return token;
    }
    @Override
    public Boolean verify(String token){
        try {
            Algorithm algorithm = Algorithm.HMAC256(TOKEN_SECRET);
            JWTVerifier verifier = JWT.require(algorithm).build();
            verifier.verify(token);
            return true;
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }


    @Override
    public Boolean deleteUser_Data(String user_email){
        Boolean temp = true;
        temp = userMapper.deleteUser(user_email) == 1;
        temp = userMapper.deleteUserData(user_email) == 1;
        return temp;
    }


    @Override
    public Integer judgeUserData(String user_email){
        Userdata user = userMapper.judgeUserData(user_email);
        if(user != null)
            return 1;
        return 0;
    }
    @Override
    public Userdata getUserdata(String user_email){
        return userMapper.getData(user_email);
    }

    @Override
    public Boolean addUser(User user){
        Integer temp = userMapper.insertUser(user);
        return temp == 1;
    }

    @Override
    public Boolean addUserDataIn(Userdata userdata){
        Integer temp = userMapper.insertData(userdata);
        return !(temp == 0);
    }
    @Override
    public Boolean updateUserdata(Userdata userdata){
        return userMapper.updateUserdata(userdata);
    }
}
