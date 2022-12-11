package com.book.servlet;

import com.book.entity.admin;
import com.book.service.Booksubmissonservice;
import com.book.service.InsborrowServlet;
import com.book.service.impl.Booksubmissonlp;
import com.book.service.impl.InsborrowServletlp;
import com.book.service.impl.borrowbooslp;
import org.thymeleaf.context.Context;
import utils.ThymeleafUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/BookSubmission")
public class BookSubmission extends HttpServlet {
    Booksubmissonservice booksubmissonservice;
    InsborrowServlet insborrowServlet;

    @Override
    public void init() throws ServletException {
        booksubmissonservice = new Booksubmissonlp();
        insborrowServlet=  new InsborrowServletlp();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html; charset=utf-8");
        Context context = new Context();
        admin admin = (admin) req.getSession().getAttribute("admin");
        context.setVariable("admin",admin.getAdmin());

        context.setVariable("books",booksubmissonservice.selecctbook());
        context.setVariable("users",booksubmissonservice.selectuser());

        ThymeleafUtil.process("BookSubmission.html",context,resp.getWriter());
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html; charset=utf-8");
        int bid = Integer.parseInt(req.getParameter("book"));
        int uid = Integer.parseInt(req.getParameter("student"));
        insborrowServlet.InsborrowServletl(uid,bid);
        this.doGet(req,resp);


    }
}
