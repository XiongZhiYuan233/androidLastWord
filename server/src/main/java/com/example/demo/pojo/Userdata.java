package com.example.demo.pojo;

import java.sql.Blob;


public class Userdata {
    private String user_email;

    private String name;

    private String sex;

    private Integer age;

    private Integer stature;

    private String phonenumber;

    private byte[] headportrait;

    public String getUser_email() {
        return user_email;
    }

    public void setUser_email(String user_email) {
        this.user_email = user_email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Integer getStature() {
        return stature;
    }

    public void setStature(Integer stature) {
        this.stature = stature;
    }

    public String getPhonenumber() {
        return phonenumber;
    }

    public void setPhonenumber(String phonenumber) {
        this.phonenumber = phonenumber;
    }

    public byte[] getHeadportrait() {
        return headportrait;
    }

    public void setHeadportrait(byte[] headportrait) {
        this.headportrait = headportrait;
    }

    public Userdata(String user_email, String name, String sex, Integer age, Integer stature, String phonenumber, byte[] headportrait) {
        this.user_email = user_email;
        this.name = name;
        this.sex = sex;
        this.age = age;
        this.stature = stature;
        this.phonenumber = phonenumber;
        this.headportrait = headportrait;
    }
    public Userdata(String user_email, String name, String sex, Integer age, Integer stature, String phonenumber) {
        this.user_email = user_email;
        this.name = name;
        this.sex = sex;
        this.age = age;
        this.stature = stature;
        this.phonenumber = phonenumber;
    }


}
