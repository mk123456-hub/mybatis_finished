package com.abc.service.impl;

import com.abc.dao.util.DBUtil;

import java.math.BigDecimal;
import java.sql.CallableStatement;
import java.sql.Connection;

/**
 * @Author Administrator
 * @create 2020/12/8 0008 14:49
 */
public class demo {
    public static void main(String[] args) throws Exception{
//        Connection con= DBUtil.getConnection();
//        CallableStatement ps=con.prepareCall("call pro_saveBtn()");
//        ps.executeUpdate();
//        DBUtil.close(null,ps,con);
        Connection con=DBUtil.getConnection();
        String sql="call pro_transform2(?,?,?)";
        CallableStatement ps=con.prepareCall(sql);
        ps.setString(1,"KING");
        ps.setString(2,"SCOTT");
        ps.setBigDecimal(3,new BigDecimal("1000"));
        ps.executeUpdate();
        DBUtil.close(null,ps,con);
    }

}
