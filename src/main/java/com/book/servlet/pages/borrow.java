package com.book.servlet.pages;

import com.book.entity.admin;
import com.book.entity.boorow;
import com.book.service.bookservlet;
import com.book.service.impl.borrowbooslp;
import org.thymeleaf.context.Context;
import utils.ThymeleafUtil;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class borrow extends HttpServlet {
    bookservlet bookservlet;
    @Override
    public void init() throws ServletException {
        bookservlet = new borrowbooslp();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        for (boorow boorow : bookservlet.bookservletl()) {

        }

        resp.setContentType("text/html; charset=utf-8");
        Context context = new Context();
        admin admin = (admin) req.getSession().getAttribute("admin");
        context.setVariable("admin",admin.getAdmin());
        ThymeleafUtil.process("book.html",context,resp.getWriter());



    }
}
