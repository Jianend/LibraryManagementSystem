package com.book.service;

import com.book.entity.user;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpSession;
import java.util.List;

public interface UserService {
    boolean auth(String username , String password, HttpSession session);

    List<user> selectuser();


}
