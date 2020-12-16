package com.abc.service.impl;

import com.abc.common.Comm;
import com.abc.dao.entity.Emp;
import com.abc.dao.util.DBUtil;
import com.abc.service.factory.ServiceFactory;
import com.abc.service.iservice.IEmpService;
import com.abc.service.iservice.IUserService;
import junit.framework.TestCase;

import java.sql.Connection;
import java.util.List;

/**
 * @Author Administrator
 * @create 2020/12/2 0002 22:44
 */
public class EmpServiceImplTest extends TestCase {

    public void testFindByPage() throws Exception{
        Connection con= DBUtil.getConnection();
        IEmpService empService= (IEmpService) ServiceFactory.getInstance(Comm.EMP);
        List<Emp> emp=empService.findByPage(1,5);
        for(Emp emp1:emp){
            System.out.println(emp1);
        }
    }

    public void testFindByName() {
        IEmpService empService= (IEmpService) ServiceFactory.getInstance(Comm.EMP);
        try {
            List<Emp> emps=empService.findByName("M");
            for(Emp emp:emps){
                System.out.println(emp);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}