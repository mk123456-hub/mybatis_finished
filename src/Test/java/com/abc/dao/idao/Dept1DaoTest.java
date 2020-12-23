package com.abc.dao.idao;

import com.abc.dao.entity.Dept1;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

import static org.junit.Assert.*;

/**
 * @Author Administrator
 * @create 2020/12/23 0023 12:13
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext.xml"})
public class Dept1DaoTest {
    @Autowired
    Dept1Dao dept1Dao;
    @Test
    public void findAll() {
        List<Dept1> all = dept1Dao.findAll();
        all.forEach((dept)->{
            System.out.println(dept.getDname());
            System.out.println(dept.getStus());
        });
    }
}