package com.lg.ls.services;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
         String username = req.getParameter("username");
         String password = req.getParameter("password");
         String role=req.getParameter("role");
         System.out.println("username:"+username);
         System.out.println("password:"+password);
         resp.setContentType("text/html;charset=utf-8");
        PrintWriter out = resp.getWriter();
        if("admin".equals(username)){
            out.write("<html>");
            out.write("<head>");
            out.write("<title>登录成功</title>");
            out.write("</head>");
            out.write("<body>");
            out.write("<h2 align='center' style='color:green'>");
            out.write("欢迎"+username+"登陆成功");
            out.write("</h2>");
            out.write("</body>");
            out.write("</html>");
        }else{
            out.write("<html>");
            out.write("<head>");
            out.write("<title>登录失败</title>");
            out.write("</head>");
            out.write("<body>");
            out.write("<h2 align='center' style='color:red'>");
            out.write("用户名或密码错误，登录失败");
            out.write("</h2>");
            out.write("</body>");
            out.write("</html>");
        }
    }
}
