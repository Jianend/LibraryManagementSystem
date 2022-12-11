package com.book.entity;

public class admin {
    private int id;
    private String admin;
    private String password;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAdmin() {
        return admin;
    }

    public void setAdmin(String admin) {
        this.admin = admin;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public admin(int id, String admin, String password) {
        this.id = id;
        this.admin = admin;
        this.password = password;
    }

    public admin() {
    }
}
