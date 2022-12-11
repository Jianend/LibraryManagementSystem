package com.book.service.impl;

import com.book.dao.bookmaooer;
import com.book.entity.book;
import com.book.entity.user;
import com.book.service.Booksubmissonservice;
import org.apache.ibatis.session.SqlSession;
import utils.MybatisUtil;

import java.util.List;

public class Booksubmissonlp implements Booksubmissonservice {

    SqlSession session = MybatisUtil.getSession();
    bookmaooer mapper = session.getMapper(bookmaooer.class);

    @Override
    public List<book> selecctbook() {

        List<book> selectallbok = mapper.selectallbok();
        return selectallbok;
    }

    @Override
    public List<user> selectuser() {
        List<user> selectalluser = mapper.selectalluser();
        return selectalluser;
    }


}
