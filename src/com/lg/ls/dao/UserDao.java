package com.lg.ls.dao;

import com.lg.ls.entity.User;
import com.lg.ls.util.JdbcUtil;

import java.sql.SQLException;
import java.util.List;

public class UserDao {
    public int add(User user){
        String sql="insert into t_user(usename,password,realname,role,creat_time) values('"
                +user.getUseName()+"','"+user.getPassword()+"','"+user.getRealname()+"','"+user.getRole()+"',now() )";
        try {
            return JdbcUtil.execute(sql);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return -1;
    }
    public User Query(String usename){
        String sql="select * from t_user where usename ='"+usename+"';";
        try {
            return JdbcUtil.queryOne(sql,User.class);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    public User Query1(String role){
        String sql="select * from t_user where role ='"+role+"';";
        try {
            return JdbcUtil.queryOne(sql,User.class);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    public List<User> queryList(){
        String sql="select * from t_user order by creat_time desc";
        try {
            return JdbcUtil.queryList(sql,User.class);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
