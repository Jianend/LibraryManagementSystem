package com.book.servlet.pages;

import com.book.entity.admin;
import com.book.service.UserService;
import com.book.service.impl.UserServiceImpl;
import org.thymeleaf.context.Context;
import utils.ThymeleafUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/students")
public class StudentServlet extends HttpServlet {
    UserService UserService;
    @Override
    public void init() throws ServletException {
        UserService=   new UserServiceImpl();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html; charset=utf-8");
        Context context = new Context();
        admin admin = (admin) req.getSession().getAttribute("admin");
        context.setVariable("admin",admin.getAdmin());
        context.setVariable("students_list",UserService.selectuser());
        ThymeleafUtil.process("students.html",context,resp.getWriter());
    }
}
