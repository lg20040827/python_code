package com.lg.ls.controller;

import com.lg.ls.services.RegistServlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/user_login")
public class LoginUserServlet extends HttpServlet {
    private RegistServlet service=new RegistServlet();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        String name=req.getParameter("usename");
        String pass=req.getParameter("password");
        String role=req.getParameter("role");
        if(service.login(name,pass,role,req.getSession())) {
            resp.sendRedirect("/prelook.html");
        }
        else {
            //失败 重新跳转到登录页面
            resp.sendRedirect("/index.html");
        }
    }
}
