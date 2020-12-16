package com.abc.controller;

import com.abc.common.Comm;
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
 * @create 2020/12/2 0002 21:47
 */
//@WebServlet(urlPatterns = {"/EmpFindByPageServlet","/empbypage"})
@WebServlet(name = "EmpFindByPageServlet",urlPatterns = {"/empbypage"})
public class EmpFindByPageServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            //1.取值
            int page = 1;
            int size = 10;
            String pageParam = request.getParameter("page");
            String sizeParam = request.getParameter("size");
            if (pageParam != null && !"".equals(pageParam.trim())) {
                page = Integer.parseInt(pageParam);
            }
            if (sizeParam != null && !"".equals(sizeParam.trim())) {
                size = Integer.parseInt(sizeParam);
            }

            //2.处理
            IEmpService empService = (IEmpService) SpringIOC.getSpring().getBean("empService");
            List<Emp> emps = null;
            try {
                emps = empService.findByPage(page, size);
            } catch (Exception e) {
                e.printStackTrace();
            }

            //3.反馈java模板引擎
            if (emps != null && emps.size() > 0) {
                request.setAttribute("empsFromServer", emps);
                request.getRequestDispatcher("/emp.jsp").forward(request, response);
            } else {
                 HttpSession session = request.getSession();
                session.setAttribute("errMsg", "查询分页失败");
                response.sendRedirect(request.getContextPath() + "/error.jsp");
            }
        }
    }

