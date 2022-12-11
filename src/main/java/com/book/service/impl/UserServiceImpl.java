package com.book.service.impl;

import com.book.dao.bookmaooer;
import com.book.dao.logindao;
import com.book.entity.admin;
import com.book.entity.user;
import com.book.service.UserService;
import org.apache.ibatis.session.SqlSession;
import utils.MybatisUtil;

import javax.servlet.http.HttpSession;
import java.util.List;

public class UserServiceImpl implements UserService {


    @Override
    public boolean auth(String username, String password, HttpSession session) {
        admin admin = new admin();
        admin.setAdmin(username);
        admin.setPassword(password);

        try(SqlSession Sqlsession = MybatisUtil.getSession()){
            logindao mapper = Sqlsession.getMapper(logindao.class);
            admin selectadmin = mapper.selectadmin(admin);
            if (selectadmin==null)return false;
            session.setAttribute("admin",admin);
            return true;
        }
    }

    @Override
    public List<user> selectuser() {
        try(SqlSession Sqlsession = MybatisUtil.getSession()){
            bookmaooer mapper = Sqlsession.getMapper(bookmaooer.class);
         return mapper.selectalluser();

        }
    }


}
