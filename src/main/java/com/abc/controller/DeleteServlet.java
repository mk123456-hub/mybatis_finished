package com.abc.controller;

import com.abc.common.Comm;
import com.abc.dao.entity.Emp;
import com.abc.service.factory.ServiceFactory;
import com.abc.service.iservice.IEmpService;
import com.abc.service.iservice.IUserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * @Author Administrator
 * @create 2020/12/3 0003 13:51
 */
@WebServlet(urlPatterns = {"/DeleteServlet","/delete"})
public class DeleteServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1.取值
        String empnoParam=request.getParameter("empno");
        System.out.println(empnoParam);
        int empno=0;
        if(empnoParam!=null && !"".equals(empnoParam.trim())){
             empno=Integer.parseInt(empnoParam);

        }
        System.out.println(empno);

        //2.处理
        IEmpService empService= (IEmpService) ServiceFactory.getInstance(Comm.EMP);
        Emp emp=new Emp();
        emp.setEmpno(empno);
        try {
            String msg=empService.delete(emp);
            if(msg.equals(Comm.SUCCESS)){
                response.sendRedirect(request.getContextPath()+"/empbypage");
            }else {
                HttpSession session=request.getSession();
                session.setAttribute("errMsg","删除数据失败");
                response.sendRedirect(request.getContextPath()+"/error.jsp");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        //3.反馈

    }
}
