package com.abc.controller;

import com.abc.dao.entity.Emp;

import com.abc.service.iservice.IEmpService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

/**
 * @Author Administrator
 * @create 2020/12/3 0003 16:34
 */
@WebServlet(name = "SearchByNameServlet",urlPatterns = {"/searchByName"})
public class SearchByNameServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1.取值
        String ename=request.getParameter("ename");
        //2.处理
        IEmpService empService= (IEmpService) SpringIOC.getSpring().getBean("empService");
        List<Emp> emps= null;
        try {
            emps = empService.findByName(ename);
            System.out.println(emps);
        } catch (Exception e) {
            e.printStackTrace();
        }

        //3.反馈java模板引擎
        if(emps!=null && emps.size()>0){
            request.setAttribute("empsFromServer",emps);
            request.getRequestDispatcher("/emp.jsp").forward(request,response);
        }else {
            HttpSession session=request.getSession();
            session.setAttribute("errMsg","模糊查询失败");
            response.sendRedirect(request.getContextPath()+"/error.jsp");
        }
    }
    }
