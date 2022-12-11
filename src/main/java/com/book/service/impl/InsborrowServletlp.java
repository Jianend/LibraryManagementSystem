package com.book.service.impl;

import com.book.dao.bookmaooer;
import com.book.entity.borrowbooks;



import com.book.service.InsborrowServlet;
import org.apache.ibatis.session.SqlSession;
import utils.MybatisUtil;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;

public class InsborrowServletlp implements InsborrowServlet {
    SqlSession session = MybatisUtil.getSession();
    bookmaooer mapper = session.getMapper(bookmaooer.class);



    @Override
    public boolean InsborrowServletl(int  uid, int  bid) {

        borrowbooks borrowbooks = new borrowbooks();
        borrowbooks.setBid(bid);
        borrowbooks.setUid(uid);
        borrowbooks.setTime(new Date().toString());
        Date nowdate=new Date();
        SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        borrowbooks.setTime(f.format(nowdate));
        return mapper.Insborrow(borrowbooks);
    }
}
