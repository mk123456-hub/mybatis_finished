package com.abc.dao.idao;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;

/**
 * @Author Administrator
 * @create 2020/12/20 0020 22:34
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext.xml"})
public class DeptDaoTest {
    @Autowired
    DeptDao deptDao;

    @Test
    public void findAll() {
        deptDao.findAll().stream().forEach(System.out::println);
    }
}