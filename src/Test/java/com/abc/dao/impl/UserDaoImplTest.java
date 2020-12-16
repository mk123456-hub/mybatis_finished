package com.abc.dao.impl;

import com.abc.common.Comm;
import com.abc.common.Res;
import com.abc.dao.util.DBUtil;
import com.abc.service.factory.ServiceFactory;
import com.abc.service.iservice.IUserService;
import junit.framework.TestCase;

import java.sql.Connection;

/**
 * @Author Administrator
 * @create 2020/12/1 0001 22:32
 */
public class UserDaoImplTest extends TestCase {

    public void testExist() throws Exception{
        Connection con=DBUtil.getConnection();
        IUserService userService= (IUserService) ServiceFactory.getInstance(Comm.USER);
        Res res=userService.userExist("scot");
        System.out.println(res.toString());
    }
}