package com.abc.dao.impl;

import com.abc.controller.vo.DelVO;
import com.abc.dao.entity.Emp;
import com.abc.dao.idao.IEmpDao;
import com.abc.dao.util.DBUtil;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author Administrator
 * @create 2020/12/2 0002 22:21
 */
@Repository("empDao")
public class EmpDaoImpl implements IEmpDao {
    @Override
    public List<Emp> findByPage(int start, int size) throws Exception{
        Connection con= DBUtil.getConnection();
        String sql="select empno,ename,hiredate,sal from emp limit ?,?";
        PreparedStatement ps=con.prepareStatement(sql);
        ps.setInt(1,start);
        ps.setInt(2,size);
        ResultSet rs=ps.executeQuery();
        List<Emp> list=new ArrayList<>();
        while (rs.next()){
            Emp emp=new Emp(rs.getInt(1),rs.getString(2),rs.getDate(3),rs.getBigDecimal(4));
            list.add(emp);
        }
        DBUtil.close(rs,ps,con);
        return list;
    }

    @Override
    public List<Emp> findByName(String name) throws Exception {
        Connection con= DBUtil.getConnection();
//        String sql="select empno,ename,hiredate,sal from emp where like concat('%',ename,'%')";
        String sql="select empno,ename,hiredate,sal from emp where ename like ?";
        PreparedStatement ps=con.prepareStatement(sql);
        ps.setString(1,"%"+name+"%");
        ResultSet rs=ps.executeQuery();
        List<Emp> list=new ArrayList<>();
        while (rs.next()){
            Emp emp=new Emp(rs.getInt(1),rs.getString(2),rs.getDate(3),rs.getBigDecimal(4));
            list.add(emp);
            System.out.println(emp);
        }
        DBUtil.close(rs,ps,con);
        return list;
    }

    @Override
    public Emp findById(Integer id) throws Exception {
        Connection con=DBUtil.getConnection();
        String sql="select empno,ename,hiredate,sal from emp where empno=?";
        PreparedStatement ps=con.prepareStatement(sql);
        ps.setInt(1,id);
        ResultSet rs=ps.executeQuery();
        Emp emp=null;
        if(rs.next()){
             emp=new Emp(rs.getInt(1),rs.getString(2),rs.getDate(3),rs.getBigDecimal(4));
        }
        return emp;
    }
    @Override
    public void delete(Emp emp) throws Exception {
        Connection con=DBUtil.getConnection();
        String sql="delete from emp where empno=?";
        PreparedStatement ps=con.prepareStatement(sql);
        ps.setInt(1,emp.getEmpno());
        ps.executeUpdate();
        DBUtil.close(null,ps,con);
    }

    @Override
    public void save(Emp emp) throws Exception {
        Connection con=DBUtil.getConnection();
        String sql="insert into emp(ename,hiredate,sal) values(?,?,?)";
        PreparedStatement ps=con.prepareStatement(sql);
        ps.setString(1,emp.getEname());
        ps.setDate(2,new java.sql.Date(emp.getHiredate().getTime()));
        ps.setBigDecimal(3,emp.getSal());
        ps.executeUpdate();
        DBUtil.close(null,ps,con);
    }

    @Override
    public void update(Emp emp) throws Exception {
        Connection con=DBUtil.getConnection();
        String sql="update emp set ename=?,hiredate=?,sal=? where empno=?";
        PreparedStatement ps=con.prepareStatement(sql);
        ps.setString(1,emp.getEname());
        ps.setDate(2,new java.sql.Date(emp.getHiredate().getTime()));
        ps.setBigDecimal(3,emp.getSal());
        ps.setInt(4,emp.getEmpno());
        ps.executeUpdate();
        DBUtil.close(null,ps,con);
    }

    @Override
    public void delBatch(List<DelVO> delVOList) throws Exception{
        Connection con=DBUtil.getConnection();
        StringBuilder builder=new StringBuilder("delete from emp where empno in(");
        for(int i=0;i<delVOList.size();i++){
            if(i==delVOList.size()-1){
                builder.append(delVOList.get(i).getEmpno()+")");
            }else {
                builder.append(delVOList.get(i).getEmpno()+",");
            }
        }
        String sql=builder.toString();
        PreparedStatement ps=con.prepareStatement(sql);
        ps.executeUpdate();
        DBUtil.close(null,ps,con);

//        Connection con=DBUtil.getConnection();
//        con.setAutoCommit(false);//关闭自动提交
//        Statement ps=con.createStatement();
//        try{
//            for(DelVO de:delVOList){
//                String sql="delete from emp where empno="+de.getEmpno();
//                ps.addBatch(sql);
//            }
//            ps.executeBatch();
//            con.commit();//手动提交
//        }catch (Exception e){
//            e.printStackTrace();
//            con.rollback();//回滚
//        }
//        DBUtil.close(null,ps,con);
    }
}
