package com.example.demo.pojo;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

//@Data
public class User {
    @JsonProperty(value = "user_email")
    private String user_email;
    @JsonProperty(value = "password_hash")
    private String password_hash;
//    password 最好用char[]存储 之后优化

    public User(String email, String passwordhash){
        if(email != null && passwordhash != null)
        {
            user_email = email;
            password_hash = passwordhash;
        }
    }

    public String getUser_email() {
        return user_email;
    }

    public void setUser_email(String user_email) {
        this.user_email = user_email;
    }

    public String getPassword_hash() {
        return password_hash;
    }

    public void setPassword_hash(String password_hash) {
        this.password_hash = password_hash;
    }
}
