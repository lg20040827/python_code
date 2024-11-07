package com.lg.ls.entity;

import java.time.LocalDateTime;

public class User {
    private Integer id;
    private String usename;
    private String password;
    private String realname;
    private String role;
    private LocalDateTime creat_time;

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", usename='" + usename + '\'' +
                ", password='" + password + '\'' +
                ", realname='" + realname + '\'' +
                ", role='" + role + '\'' +
                ", creat_time=" + creat_time +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUseName() {
        return usename;
    }

    public void setUseName(String usename) {
        this.usename = usename;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRealname() {
        return realname;
    }

    public void setRealname(String realname) {
        this.realname = realname;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public LocalDateTime getCreateTime() {
        return creat_time;
    }

    public void setCreateTime(LocalDateTime creat_time) {
        this.creat_time = creat_time;
    }
}
