package com.abc.dao.util;

import junit.framework.TestCase;

import java.sql.Connection;

/**
 * @Author Administrator
 * @create 2020/12/1 0001 22:01
 */
public class DBUtilTest extends TestCase {

    public void testGetConnection() throws Exception{
        Connection con=DBUtil.getConnection();
        System.out.println("88888888888888888"+con);
    }
}