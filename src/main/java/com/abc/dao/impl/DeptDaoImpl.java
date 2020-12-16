package com.abc.dao.impl;

import com.abc.dao.entity.Dept;
import com.abc.dao.entity.Emp;
import com.abc.dao.idao.IDeptDao;
import com.abc.dao.util.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author Administrator
 * @create 2020/12/7 0007 15:34
 */
public class DeptDaoImpl implements IDeptDao {
    @Override
    public List<Dept> findAll() throws Exception{
        Connection con= DBUtil.getConnection();
        String sql="select deptno,dname from dept";
        PreparedStatement ps=con.prepareStatement(sql);
        ResultSet rs=ps.executeQuery();
        List<Dept> list=new ArrayList<Dept>();
        while (rs.next()){
            Dept dept=new Dept(rs.getInt(1),rs.getString(2));
            list.add(dept);
        }
        DBUtil.close(rs,ps,con);
        return list;
    }
}
