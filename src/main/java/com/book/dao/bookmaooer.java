package com.book.dao;

import com.book.entity.book;
import com.book.entity.borrowbooks;
import com.book.entity.user;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface bookmaooer {
    @Select("select * from book where bid=#{bid}")
    book  selectbook( book book);

    @Select("select * from user where uid=#{uid}")
    user selectuser(user user);

    @Select("select * from book where name=#{name}")
    book selectbookbyname( String name);


    @Select("select * from user where name=#{name}")
    user selectuserbyname(String  name);


    @Select("select * from borrowbooks ")
    List<borrowbooks> selectborrow();


    @Select("select * from book")
    List<book> selectallbok();


    @Select("select * from user")
    List<user> selectalluser();


    @Insert("insert into borrowbooks values (#{id},#{uid},#{bid},#{time})")
    boolean Insborrow(borrowbooks borrowbooks);

}
