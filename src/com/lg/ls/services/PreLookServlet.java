package com.lg.ls.services;

import com.lg.ls.dao.PreLookDao;
import com.lg.ls.entity.PreLook;

import java.util.List;

public class PreLookServlet{
    private PreLookDao dao=new PreLookDao();
    /**
     * 新增预约*/
    public boolean add(PreLook look){
        return dao.add(look)>0;
    }
    /**
     * 查询我的预约*/
    public List<PreLook> queryMy(Integer uid){
        return dao.queryByUid(uid);
    }
    /**
     * 查询全部预约*/
    public List<PreLook> queryAll(){
        return dao.queryList();
    }
}
