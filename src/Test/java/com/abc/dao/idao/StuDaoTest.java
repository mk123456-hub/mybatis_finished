package com.abc.dao.idao;

import com.abc.dao.entity.Student;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

import static org.junit.Assert.*;

/**
 * @Author Administrator
 * @create 2020/12/22 0022 14:04
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations ={"classpath:applicationContext.xml"})
public class StuDaoTest {
    @Autowired
    StuDao stuDao;

    @Test
    public void one2many() {



    }
}