package com.lg.ls.util;

import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class JdbcUtil {
    /**
     * 线程副本 解决线程安全*/
    private static ThreadLocal<Connection> local=new ThreadLocal<>();
    /**
     * 静态代码块 初始化执行 实例化 静态属性*/
    static {
        //1.加载驱动 固定
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    private static Connection init() throws SQLException {
        //2.创建连接 半固定，需要把连接信息换成你的
        return DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/lgjava","root","123456");
    }

    /**
     * 新增、修改、删除
     * @param sql 对应要执行的sql语句*/
    public static int execute(String sql) throws SQLException {
        Connection connection=local.get();
        if(connection==null){
            connection=init();
            local.set(connection);
        }
        System.err.println(sql);
        return connection.createStatement().executeUpdate(sql);
    }
    /**
     * 查询
     * @param sql 对应要执行的sql语句
     * @param clz 对应类的Class对象
     * @return 查询结果-对象*/
    public static <T> T queryOne(String sql,Class<T> clz) throws Exception {
        ResultSet resultSet=query(sql);
        T obj=clz.newInstance();
        while (resultSet.next()){
            Field[] fields=clz.getDeclaredFields();
            for (Field f:fields){
                f.setAccessible(true);
                try {
                    f.set(obj,resultSet.getObject(rename(f.getName())));
                }catch (Exception e){}
            }
        }
        resultSet.close();
        return obj;
    }

    private static ResultSet query(String sql) throws SQLException {
        Connection connection=local.get();
        if(connection==null){
            connection=init();
            local.set(connection);
        }
        return connection.createStatement().executeQuery(sql);
    }
    /**
     * 查询
     * @param sql 对应要执行的sql语句
     * @param clz 对应类的Class对象
     * @return 查询结果-集合*/
    public static <T> List<T> queryList(String sql, Class<T> clz) throws Exception {
        ResultSet resultSet=query(sql);
        List<T> list=new ArrayList<>();
        while (resultSet.next()){
            T obj=clz.newInstance();
            Field[] fields=clz.getDeclaredFields();
            for (Field f:fields){
                f.setAccessible(true);
                try {
                    System.out.println(resultSet.getObject(rename(f.getName())));
                    f.set(obj,resultSet.getObject(rename(f.getName())));
                }catch (Exception e){}

            }
            list.add(obj);
        }
        resultSet.close();
        return list;
    }
    public static String rename(String name){
        //createTime  create_time
        String n="";
        for(char c:name.toCharArray()){
            if(c>64 && c<91){
                n+="_"+c;
            }else {
                n+=c;
            }
        }
        return n.toLowerCase();
    }
}


