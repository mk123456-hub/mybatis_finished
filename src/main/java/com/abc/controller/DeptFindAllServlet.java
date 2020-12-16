package com.abc.controller;

import com.abc.common.Res;
import com.abc.dao.entity.Dept;
import com.abc.service.iservice.IDeptService;
import com.alibaba.fastjson.JSON;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

/**
 * @Author Administrator
 * @create 2020/12/7 0007 15:16
 */
@WebServlet(name = "DeptFindAllServlet",urlPatterns = {"/deptfindall"})
public class DeptFindAllServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        IDeptService deptService= (IDeptService) SpringIOC.getSpring().getBean("deptService");
        Res<List<Dept>> res=null;
        try {
             res=deptService.findAll();
        } catch (Exception e) {
            e.printStackTrace();
        }
        PrintWriter out=response.getWriter();
        Object result= JSON.toJSONString(res);
        out.println(result);
        out.close();
    }
}
