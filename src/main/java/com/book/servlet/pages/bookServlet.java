package com.book.servlet.pages;

import com.book.entity.admin;
import com.book.service.bookservlet;
import com.book.service.impl.borrowbooslp;
import org.thymeleaf.context.Context;
import utils.ThymeleafUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/book")
public class bookServlet extends HttpServlet {

    bookservlet bookservlet;
    @Override
    public void init() throws ServletException {
        bookservlet=new borrowbooslp();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html; charset=utf-8");
        Context context = new Context();
        admin admin = (admin) req.getSession().getAttribute("admin");
        context.setVariable("admin",admin.getAdmin());
        context.setVariable("book_list",bookservlet.bookst());

        ThymeleafUtil.process("book.html",context,resp.getWriter());
    }
}
