package com.lg.ls.controller;

import com.lg.ls.services.PreLookServlet;
import com.lg.ls.dao.PreLookDao;
import com.lg.ls.entity.PreLook;
import com.lg.ls.entity.User;
import com.lg.ls.services.PreLookServlet;
import com.lg.ls.services.RegistServlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

@WebServlet( value = "/look_add")
public class AddLookServlet extends HttpServlet {
    private PreLookServlet service=new PreLookServlet();
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        //1.请求 从请求中获取信息
        PreLook look=new PreLook();
        look.setName(request.getParameter("NAME"));
        look.setInfo(request.getParameter("info"));
        look.setSchool(request.getParameter("school"));
        look.setPhone(request.getParameter("phone"));
        look.setVdate(Date.valueOf(LocalDate.parse(request.getParameter("vdate"))));
        look.setUid(((User)request.getSession().getAttribute("user")).getId());

        //2.调用业务层 方法 实现注册
        if(service.add(look)){
            //成功 查询我的预约信息
            List<PreLook> list=service.queryMy(look.getUid());
            response.setContentType("text/html;characterencoding=UTF-8");
            response.setCharacterEncoding("UTF-8");
            response.getWriter().println(createHtml(list));
        }else {
            //失败 重新跳转注册页面
            response.sendRedirect("/prelook.html");
        }
    }

    private String createHtml(List<PreLook> list) {
        StringBuffer buffer = new StringBuffer();
        buffer.append("<!DOCTYPE html>\n" +
                "<html lang=\"en\">\n" +
                "<head>\n" +
                "    <meta charset=\"UTF-8\">\n" +
                "    <title>预约参观申请-LookSys</title>\n" +
                "    <style>\n" +
                "        .dv1{\n" +
                "            margin: 20px;\n" +
                "        }\n" +
                "        input{\n" +
                "            width: 200px;\n" +
                "        }\n" +
                "        label,input,button{\n" +
                "            padding: 5px;\n" +
                "            font-size: 20px;\n" +
                "        }\n" +
                "        td,th{\n" +
                "            padding: 8px;\n" +
                "            border: 1px solid bisque;\n" +
                "        }\n" +
                "    </style>\n" +
                "</head>\n" +
                "<body>\n" +
                "<div>\n" +
                "    <div style=\"float:left;;width: 35%;text-align: center\">\n" +
                "        <h1>新增预约参观信息</h1>\n" +
                "        <form action=\"\" method=\"\">\n" +
                "            <div class=\"dv1\">\n" +
                "                <label>姓名：</label>\n" +
                "                <input name=\"NAME\" placeholder=\"请输入姓名\">\n" +
                "            </div>\n" +
                "            <div class=\"dv1\">\n" +
                "                <label>手机：</label>\n" +
                "                <input name=\"phone\" placeholder=\"请输入手机\">\n" +
                "            </div>\n" +
                "            <div class=\"dv1\">\n" +
                "                <label>学校：</label>\n" +
                "                <input name=\"school\" placeholder=\"请输入学校\">\n" +
                "            </div>\n" +
                "            <div class=\"dv1\">\n" +
                "                <label>日期：</label>\n" +
                "                <input name=\"vdate\" type=\"date\" placeholder=\"请输入日期\">\n" +
                "            </div>\n" +
                "            <div class=\"dv1\">\n" +
                "                <label>申请：</label>\n" +
                "                <input name=\"info\" placeholder=\"请输入参观原因\">\n" +
                "            </div>\n" +
                "            <div class=\"dv1\"f>\n" +
                "                <button>新增参观预约申请</button>\n" +
                "            </div>\n" +
                "        </form>\n" +
                "    </div>\n" +
                "\n" +
                "    <div style=\"float: right;width: 65%\">\n" +
                "        <h1>我的预约申请列表</h1>\n" +
                "        <div>\n" +
                "            <table>\n" +
                "                <thead>\n" +
                "                <tr>\n" +
                "                    <th>序号</th>\n" +
                "                    <th>姓名</th>\n" +
                "                    <th>手机号</th>\n" +
                "                    <th>参观学校</th>\n" +
                "                    <th>参观日期</th>\n" +
                "                    <th>参观原因</th>\n" +
                "                    <th>申请时间</th>\n" +
                "                </tr>\n" +
                "                </thead>\n" +
                "                <tbody>\n");
        list.forEach(l -> {
            buffer.append("<tr>\n" +
                    "<td>" + l.getId() + "</td>\n" +
                    "<td>" + l.getName() + "</td>\n" +
                    "<td>" + l.getPhone() + "</td>\n" +
                    "<td>" + l.getSchool() + "</td>\n" +
                    "                    <td>" + l.getVdate() + "</td>\n" +
                    "                    <td>" + l.getInfo() + "</td>\n" +
                    "                    <td>" + l.getCreateTime() + "</td>\n" +
                    "                </tr>\n");
        });
        buffer.append(
                "                </tbody>\n" +
                        "            </table>\n" +
                        "        </div>\n" +
                        "    </div>\n" +
                        "</div>\n" +
                        "</body>\n" +
                        "</html>");
        return buffer.toString();
    }
}
