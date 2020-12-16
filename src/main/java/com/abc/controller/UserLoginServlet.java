package com.abc.controller;

import com.abc.common.Comm;
import com.abc.common.Res;
import com.abc.dao.entity.User;
import com.abc.service.factory.ServiceFactory;
import com.abc.service.iservice.IUserService;
import com.alibaba.fastjson.JSON;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @Author Administrator
 * @create 2020/12/2 0002 14:23
 */
@WebServlet(urlPatterns = {"/UserLoginServlet","/login"})
public class UserLoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1.取值
        String username=request.getParameter("username");
        String password=request.getParameter("password");

        //2.处理
        User user=new User(username,password);
        IUserService userService= (IUserService) ServiceFactory.getInstance(Comm.USER);
        Res<User> res= null;

        try {
            res = userService.login(user);
        } catch (Exception e) {
            e.printStackTrace();
        }
        HttpSession session=request.getSession();
        session.setAttribute(Comm.CURRENT_USER,res.getData());

        //3.反馈
        response.setCharacterEncoding("utf-8");
        PrintWriter out=response.getWriter();
        Object resultJson=JSON.toJSONString(res);
        out.println(resultJson);
        out.close();
    }
}
