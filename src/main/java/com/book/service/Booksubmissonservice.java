package com.book.service;

import com.book.entity.book;
import com.book.entity.user;

import java.util.List;

public interface Booksubmissonservice {
    List<book> selecctbook();

    List<user> selectuser();
}
