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
import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @Author Administrator
 * @create 2020/12/4 0004 12:00
 */
@WebServlet(name = "UpdateEmpServlet",urlPatterns = {"/updateemp"})
public class UpdateEmpServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int empno=Integer.parseInt(request.getParameter("empno"));
        String ename=request.getParameter("ename");
        Date hiredate=null;
        try {
            hiredate = new SimpleDateFormat("yyyy-MM-dd").parse(request.getParameter("hiredate"));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        System.out.println(hiredate);
        BigDecimal sal=new BigDecimal(request.getParameter("sal"));

        IEmpService empService= (IEmpService) SpringIOC.getSpring().getBean("empService");
        Emp emp=new Emp(empno,ename,hiredate,sal);
        System.out.println(emp);
        try {
            String msg=empService.update(emp);
            if(msg.equals(Comm.SUCCESS)){
                response.sendRedirect(request.getContextPath()+"/empbypage");
            }else {
                HttpSession session=request.getSession();
                session.setAttribute("errMsg","修改数据失败");
                response.sendRedirect(request.getContextPath()+"/error.jsp");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
