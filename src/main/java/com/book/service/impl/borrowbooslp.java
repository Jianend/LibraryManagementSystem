package com.book.service.impl;

import com.book.dao.bookmaooer;
import com.book.entity.book;
import com.book.entity.boorow;
import com.book.entity.borrowbooks;
import com.book.entity.user;
import com.book.service.bookservlet;
import org.apache.ibatis.session.SqlSession;
import utils.MybatisUtil;

import java.util.ArrayList;
import java.util.List;

public class borrowbooslp implements bookservlet {

    SqlSession session = MybatisUtil.getSession();
    bookmaooer mapper = session.getMapper(bookmaooer.class);
    @Override
    public List<boorow> bookservletl() {

           List<boorow> boorows=new ArrayList<boorow>();
           List<borrowbooks> selectborrow = mapper.selectborrow();
           for (borrowbooks borrowbooks : selectborrow) {
               book selectbook = mapper.selectbook(new book(borrowbooks.getBid()));
               user selectuser = mapper.selectuser(new user(borrowbooks.getUid()));
               if (selectbook != null)
                   if (selectuser!=null) {
                       boorow boorowss = new boorow();
                       boorowss.setTime(borrowbooks.getTime());
                       boorowss.setBook(selectbook);
                       boorowss.setUser(selectuser);
                       boorows.add(boorowss);
                   }
           }



        return boorows;

    }

    @Override
    public List<book> bookst() {
        return mapper.selectallbok();
    }
}
