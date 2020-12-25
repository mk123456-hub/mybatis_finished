package com.abc.dao.idao;

import com.abc.dao.entity.Emp;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import static org.junit.Assert.*;

/**
 * @Author Administrator
 * @create 2020/12/20 0020 23:49
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext.xml"})
public class EmpDaoTest {
    @Autowired
    EmpDao empDao;
    @Test
    public void findByPage() {
        empDao.findByPage(1,5).stream().forEach(System.out::println);
    }

    @Test
    public void findByName() {
        empDao.findByName("n").stream().forEach(System.out::println);

    }

    @Test
    public void findById() {
        Emp byId = empDao.findById(7698);
        System.out.println(byId);
    }

    @Test
    public void delete() {
        Emp emp=empDao.findById(7782);
        empDao.delete(emp);
        findByPage();
    }
    @Test
    public void find() throws Exception{
        Date date= new SimpleDateFormat("yyyy-MM-dd").parse("1981-10-03");
        empDao.find("M",date,new BigDecimal("3000")).forEach(System.out::println);
//        empDao.find(null,date,new BigDecimal("3000")).forEach(System.out::println);
//        empDao.find(null,null,new BigDecimal("3000")).forEach(System.out::println);
    }

    @Test
    public void save() {
//        Emp emp=new Emp("哈哈",new Date(),new BigDecimal("12345"));
//        empDao.save(emp);
    }

     @Test
    public void delBach(){
        empDao.delBatch(Arrays.asList(7788,7839));
     }
     @Test
     public void saveBath(){
//         List<Emp> emps=Arrays.asList(
//                 new Emp("emp1001",new Date(),new BigDecimal("1234")),
//                 new Emp("emp1002",new Date(),new BigDecimal("1234")),
//                 new Emp("emp1003",new Date(),new BigDecimal("1234"))
//         );
//         System.out.println(empDao.saveBatch(emps));
     }
     @Test
     public void dycUpdate(){
        Emp emp=new Emp();
        emp.setEmpno(7938);
        emp.setEname("hh");
        empDao.dymicUpdateBatch(emp);

     }

    @Test
    public void update() {
        Emp emp=empDao.findById(7782);
        emp.setEname("tom");
        emp.setSal(new BigDecimal("5555"));
        empDao.update(emp);
    }
    @Test
    public void findByDeptno(){
        empDao.findByDeptno(10).forEach(System.out::println);
    }
}