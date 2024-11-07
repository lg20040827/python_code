package com.lg.ls.dao;

import com.lg.ls.entity.PreLook;
import com.lg.ls.util.JdbcUtil;

import java.sql.SQLException;
import java.util.List;

public class PreLookDao {
    public int add(PreLook look){
        String sql="insert into t_prelook(uid,NAME,school,phone,vdate,info,create_time) values('"
                +look.getUid()+"','"+look.getName()+"','"+look.getSchool()+"','"+look.getPhone()+"','"+look.getVdate()+"','"+look.getInfo()+"',now())";
        try {
            return JdbcUtil.execute(sql);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return -1;
    }
    public List<PreLook> queryByUid(Integer uid){
        //1.sql语句
        String sql="select * from t_prelook where uid="+uid+" order by create_time desc;";
        System.out.println(sql);
        //2.执行查询
        try {
            return JdbcUtil.queryList(sql,PreLook.class);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<PreLook> queryList(){
        //1.sql语句
        String sql="select * from t_prelook order by create_time desc";
        //2.执行查询
        try {
            return JdbcUtil.queryList(sql,PreLook.class);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

}
