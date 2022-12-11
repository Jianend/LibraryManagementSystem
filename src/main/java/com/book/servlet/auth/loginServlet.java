package com.book.servlet.auth;


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

@WebServlet("/longin")
public class loginServlet  extends HttpServlet {

    UserService service;

    @Override
    public void init() throws ServletException {
        service=new UserServiceImpl();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html; charset=utf-8");
        Context context = new Context();
        if (req.getSession().getAttribute("login-failure") !=null){
            context.setVariable("failure",true);
            req.getSession().removeAttribute("login-failure");
        }else {
           if (req.getSession().getAttribute("admin")!=null){
            resp.sendRedirect("index");
           }

        }

        ThymeleafUtil.process("login.html",context,resp.getWriter());
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("user");
        String password = req.getParameter("password");
        String parameter = req.getParameter("remember-me");
        if (service.auth(username,password, req.getSession())){
            resp.setContentType("text/html; charset=utf-8");
            resp.sendRedirect("index");

        }else {
                req.getSession().setAttribute("login-failure",new Object());
            this.doGet(req,resp);
        }


    }
}
