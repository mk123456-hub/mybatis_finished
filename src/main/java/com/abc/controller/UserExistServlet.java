package com.abc.controller;
import com.abc.common.Res;

import com.abc.service.iservice.IUserService;
import com.alibaba.fastjson.JSON;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(urlPatterns = {"/UserExistServlet","/userexist"})
public class UserExistServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //1-取值
        System.out.println("-----------------------");
        String username = req.getParameter("username");
        //2-处理
        IUserService userService = (IUserService) SpringIOC.getSpring().getBean("userService");
        System.out.println(userService);
        Res res = null;
        try {
            res = userService.userExist(username);
            System.out.println(res);
        } catch (Exception e) {
            e.printStackTrace();
        }
        //3-反馈
        resp.setCharacterEncoding("utf-8");
        PrintWriter out = resp.getWriter();
        Object resJson = JSON.toJSONString(res);
        out.println(resJson);
        out.close();
    }
}
