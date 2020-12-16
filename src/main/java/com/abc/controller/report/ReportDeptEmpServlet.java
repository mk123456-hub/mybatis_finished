package com.abc.controller.report;

import com.abc.common.Res;
import com.abc.controller.SpringIOC;
import com.abc.controller.vo.DeptEmpVO;
import com.abc.service.dto.DeptEmpDTO;
import com.abc.service.iservice.IReportService;
import com.alibaba.fastjson.JSON;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.util.List;

/**
 * @Author Administrator
 * @create 2020/12/7 0007 21:10
 */
@WebServlet(name = "ReportDeptEmpServlet",urlPatterns = {"/reportdeptemp"})
public class ReportDeptEmpServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int deptno=Integer.parseInt(request.getParameter("deptno"));
        BigDecimal minsal=new BigDecimal(request.getParameter("min"));
        BigDecimal maxsal=new BigDecimal(request.getParameter("max"));

        DeptEmpVO deptEmpVO=new DeptEmpVO(deptno,minsal,maxsal);
        IReportService reportService= (IReportService) SpringIOC.getSpring().getBean("deptempService");
        Res<List<DeptEmpDTO>> res=reportService.makeReportForDeptEmp(deptEmpVO);

        PrintWriter out=response.getWriter();
        Object result= JSON.toJSONString(res);
        out.println(result);
        out.close();



    }

}
