package com.lg.ls.services;

import com.lg.ls.dao.UserDao;
import com.lg.ls.entity.User;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpSession;
import java.util.List;

public class RegistServlet extends HttpServlet {
     private UserDao dao=new UserDao();
     public boolean add(User user){
          return dao.add(user)>0;
     }
     public boolean Q1(String name,String role){
          User user=dao.Query(name);
          if(user.getRole().equals(role)){
               return true;
          }
          return false;
     }
     public boolean login(String name, String password, String role,HttpSession session){
          //1.查询数据库
          User user=dao.Query(name);
          //2.验证用户是否存在
          if(user==null){
               return false;
          }
          //3.验证密码
          if(user.getPassword().equals(password)){
               //登录成功
               session.setAttribute("user",user);
               return true;
          }
          return false;
     }
     public List<User> queryAll(){
          return dao.queryList();
     }
}
