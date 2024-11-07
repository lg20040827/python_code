package com.lg.ls.entity;

import com.lg.ls.util.JdbcUtil;

import java.sql.Date;
import java.time.LocalDate;
import java.time.LocalDateTime;

public class PreLook {
    private Integer id;
    private Integer uid;
    private String NAME;
    private String school;
    private String phone;
    private String info;
    private Date vdate;
    private LocalDateTime create_time;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public String getName() {
        return NAME;
    }

    public void setName(String NAME) {
        this.NAME = NAME;
    }

    public String getSchool() {
        return school;
    }

    public void setSchool(String school) {
        this.school = school;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public Date getVdate() {
        return vdate;
    }

    public void setVdate(Date vdate) {
        this.vdate = vdate;
    }

    public LocalDateTime getCreateTime() {
        return create_time;
    }

    public void setCreateTime(LocalDateTime create_time) {
        this.create_time = create_time;
    }
}
