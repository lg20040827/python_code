package com.lg.ls.controller;

import com.lg.ls.entity.User;
import com.lg.ls.services.LoginServlet;
import com.lg.ls.services.RegistServlet;
import com.mysql.cj.jdbc.Driver;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
@WebServlet(value = "/user_add")
public class AddUserServlet extends HttpServlet {
    private RegistServlet  servlet=new RegistServlet();
    @Override

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        User user =new User();
//         Driver driver;
         user.setRealname(req.getParameter("realname"));
         user.setPassword(req.getParameter("password"));
         user.setUseName(req.getParameter("usename"));
         user.setRole(req.getParameter("role"));
         if(servlet.add(user)) {
             resp.sendRedirect("/index.html");
         }else{
             resp.sendRedirect("/register.html");
         }
    }
}
