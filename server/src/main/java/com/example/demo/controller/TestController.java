package com.example.demo.controller;

import com.alibaba.fastjson.JSON;
import com.auth0.jwt.JWT;
import com.auth0.jwt.interfaces.Claim;
import com.example.demo.pojo.User;
import com.example.demo.pojo.Userdata;
import com.example.demo.service.UserService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.sql.SQLException;
import java.util.*;

@RestController
@CrossOrigin(origins = "*")
public class TestController {
    @Autowired
    private UserService userService;


    //获取用户数据，目前仅为获取图片
    @GetMapping("/getdata")
    public String[] getData(@RequestHeader String token) throws SQLException, IOException {
        System.out.println(token);
        Map<String, Claim> claims = JWT.decode(token).getClaims();
        Userdata datas = userService.getUserdata(claims.get("user_email").asString());
        if (datas.getHeadportrait() == null)
            return null;
        // byte[]转base64
        String base64Str = Base64.getEncoder().encodeToString(datas.getHeadportrait());
//        System.out.println("没有异常");
        String[] result = new String[2];
        result[0] = base64Str;
        result[1] = datas.getName();
        return result;
    }


    //返回token
    @PostMapping("/login")
    public String userLogin(@RequestBody User user){
//        System.out.println(user);
        //请求token
        System.out.println();
        System.out.println(user.getPassword_hash());

        Integer result = userService.judgeUser(user.getUser_email(),user.getPassword_hash());
        if (result!=0){
            return userService.getToken(user.getUser_email(),user.getPassword_hash());
        }
        return "default";
    }

    //发布用户数据
    @PostMapping("/user_data")
    public Boolean insertUserData(@RequestHeader String token,@RequestBody Userdata userdata){
        Boolean verifier = userService.verify(token);
        if (!verifier)
            return false;
        return userService.addUserDataIn(userdata);
    }

    @PostMapping("/update_user_data")
    public Boolean updateUserData(
            @RequestHeader String token,
            @RequestParam(value = "user_email",required = false) String user_email,
            @RequestParam(value = "name",required = false) String name,
            @RequestParam(value = "sex",required = false) String sex,
            @RequestParam(value = "age",required = false) Integer age,
            @RequestParam(value = "stature",required = false) Integer stature,
            @RequestParam(value = "phonenumber",required = false) String phonenumber,
            @RequestPart(value = "headportrait",required = false) MultipartFile headportrait
    ) throws IOException {
        Boolean verifier = userService.verify(token);
        if (!verifier)
            return false;
        Map<String, Claim> claims = JWT.decode(token).getClaims();
        if(user_email==null)
            user_email = claims.get("user_email").asString();
        Userdata userdata;
        if(headportrait != null)
            userdata = new Userdata(user_email,name,sex,age,stature,phonenumber,headportrait.getBytes());
        else
            userdata = new Userdata(user_email,name,sex,age,stature,phonenumber);
        if(userService.judgeUserData(user_email) == 1)
            return userService.updateUserdata(userdata);
        else
            return userService.addUserDataIn(userdata);
    }


    @PostMapping("/addUser")
    public Boolean addUser(@RequestBody User user){
        boolean temp = true;
        temp = userService.addUser(user);
        temp = userService.addUserDataIn(new Userdata(user.getUser_email(),"未知","未知",0,0,"未知",new byte[1]));
        return temp;
    }
    @PostMapping("/admin_addUser")
    public Boolean adminAddUser(@RequestHeader String token,@RequestBody User user){
        Map<String, Claim> claims = JWT.decode(token).getClaims();
        if (Objects.equals(claims.get("user_email").asString(), "system_admin") && Objects.equals(claims.get("password_hash").asString(), "0hyF)AQ7dnZ4%aHo8UlIg#25Kv=3|~1G")){
            boolean temp = true;
            temp = userService.addUser(user);
            temp = userService.addUserDataIn(new Userdata(user.getUser_email(),"未知","未知",0,0,"未知",new byte[1]));
            return temp;
        }else
            return false;
    }

    @PostMapping("/admin_deleteUser")
    public Boolean deleteUser(@RequestHeader String token,@RequestParam(value = "user_email",required = false) String user_email){
        Map<String, Claim> claims = JWT.decode(token).getClaims();
        if (Objects.equals(claims.get("user_email").asString(), "system_admin") && Objects.equals(claims.get("password_hash").asString(), "0hyF)AQ7dnZ4%aHo8UlIg#25Kv=3|~1G")) {
            return userService.deleteUser_Data(user_email);
        }else
            return false;
    }


    //admin账号
    //system_admin
    //0hyF)AQ7dnZ4%aHo8UlIg#25Kv=3|~1G
    @PostMapping("/admin_login")
    public String adminLogin(@RequestBody User user){
//        System.out.println(user);
        //请求token
        Integer result = userService.judgeUser(user.getUser_email(),user.getPassword_hash());
        if (Objects.equals(user.getUser_email(), "system_admin") && Objects.equals(user.getPassword_hash(), "0hyF)AQ7dnZ4%aHo8UlIg#25Kv=3|~1G")){
            return userService.getToken(user.getUser_email(),user.getPassword_hash());
        }
        return "default";
    }

    @GetMapping("/admin_getdata")
    public List<Userdata> getALLUser(@RequestHeader String token){
        Map<String, Claim> claims = JWT.decode(token).getClaims();
        if (Objects.equals(claims.get("user_email").asString(), "system_admin") && Objects.equals(claims.get("password_hash").asString(), "0hyF)AQ7dnZ4%aHo8UlIg#25Kv=3|~1G")){
            List<Userdata> allUser = userService.findALLUser();
            return allUser;
        }else
            return null;
    }
//    @GetMapping("/admin")
//    public void get




    //    @PostMapping("/login")
//    public void handleRequest(HttpServletRequest request, @RequestBody String requestBody) {
//        // 打印请求的所有消息
//        System.out.println("Request URL: " + request.getRequestURL());
//        System.out.println("Request Method: " + request.getMethod());
//        System.out.println("Request Headers: " + request.getHeaderNames());
//        System.out.println("Request Body: " + requestBody);
//    }


//  测试接口-------------
//    @GetMapping("/test")
//    public void test() throws IOException, SQLException {
//        File image = new File("src/main/resources/static/wallhaven-4ykzvd.jpg");
//        byte[] byte_image = FileCopyUtils.copyToByteArray(image);
////        Blob blob_image = new SerialBlob(byte_image);
//        userService.addUserIn(1, byte_image);
//
//
////        String put_path = "src/main/resources/static/wallhaven-4ykzvd_copy.jpg";
////
////
////        ByteArrayInputStream inputStream = new ByteArrayInputStream(byte_image);
////        BufferedImage image_copy = ImageIO.read(inputStream);
////        ImageIO.write(image_copy,"jpg",new FileOutputStream(put_path));
//    }


}
