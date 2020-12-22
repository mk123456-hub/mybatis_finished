package com.abc.dao.idao;

import com.abc.controller.vo.DeptEmpVO;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.math.BigDecimal;

import static org.junit.Assert.*;

/**
 * @Author Administrator
 * @create 2020/12/21 0021 13:22
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext.xml"})
public class ReportDaoTest {
    @Autowired
    ReportDao reportDao;
    @Test
    public void makeReportForDeptEmp() {
        reportDao.makeReportForDeptEmp(new DeptEmpVO(10,new BigDecimal("2000"),new BigDecimal("5000"))).forEach(System.out::println);
    }
}