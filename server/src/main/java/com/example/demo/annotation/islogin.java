package com.example.demo.annotation;

import com.example.demo.service.Impl.UserServiceImpl;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;

public @interface islogin {
    UserService userService = null;

}
