package com.book.dao;

import com.book.entity.admin;
import org.apache.ibatis.annotations.Select;

public interface logindao {
   @Select("select * from  admin where admin = #{admin} and password = #{password}")
    admin selectadmin(admin user);
}
