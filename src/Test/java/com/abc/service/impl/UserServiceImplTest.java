package com.abc.service.impl;
import com.abc.common.Comm;
import com.abc.common.Res;
import com.abc.dao.entity.User;
import com.abc.dao.util.DBUtil;
import com.abc.service.factory.ServiceFactory;
import com.abc.service.iservice.IUserService;
import junit.framework.TestCase;

import java.sql.Connection;

/**
 * @Author Administrator
 * @create 2020/12/2 0002 0:01
 */
public class UserServiceImplTest extends TestCase {

    public void testUserExist() throws Exception{
        Connection con= DBUtil.getConnection();
        IUserService userService= (IUserService) ServiceFactory.getInstance(Comm.USER);
        Res res=userService.userExist("scot");
        System.out.println(res.toString());
    }

}