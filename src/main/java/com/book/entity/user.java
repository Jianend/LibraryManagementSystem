package com.book.entity;


public class user {
    private  int  uid;
    private  String name;
    private  String sex;

    public user(int uid, String name, String sex) {
        this.uid = uid;
        this.name = name;
        this.sex = sex;
    }

    public user() {
    }

    public user(int uid) {
        this.uid = uid;
    }

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
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
}
