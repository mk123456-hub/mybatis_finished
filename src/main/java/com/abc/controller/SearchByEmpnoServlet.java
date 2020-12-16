package com.abc.controller;

import com.abc.common.Comm;
import com.abc.dao.entity.Emp;
import com.abc.service.factory.ServiceFactory;
import com.abc.service.iservice.IEmpService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author Administrator
 * @create 2020/12/3 0003 15:45
 */
@WebServlet(urlPatterns ={"/SearchByEmpnoServlet","/searchByEmpno"})
public class SearchByEmpnoServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1.取值
        int empno=Integer.parseInt(request.getParameter("empno"));
        //2.处理

        IEmpService empService= (IEmpService) ServiceFactory.getInstance(Comm.EMP);
        try {
            List<Emp> emps=new ArrayList<>();
            Emp emp= empService.findById(empno);
            if(emp!=null){
                emps.add(emp);
                request.setAttribute("empsFromServer",emps);
                request.getRequestDispatcher("/emp.jsp").forward(request,response);
            }else {
                HttpSession session=request.getSession();
                session.setAttribute("errMsg","精确查询失败");
                response.sendRedirect(request.getContextPath()+"/error.jsp");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1.取值
        int empno=Integer.parseInt(request.getParameter("empno"));
        //2.处理

        IEmpService empService= (IEmpService) ServiceFactory.getInstance(Comm.EMP);
        try {
            Emp emp= empService.findById(empno);
            if(emp!=null){
                request.setAttribute("emp",emp);
                request.getRequestDispatcher("/updateemp.jsp").forward(request,response);
            }else {
                HttpSession session=request.getSession();
                session.setAttribute("errMsg","修改失败");
                response.sendRedirect(request.getContextPath()+"/error.jsp");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
