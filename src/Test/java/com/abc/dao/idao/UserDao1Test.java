package com.abc.dao.idao;

import com.abc.dao.entity.User;
import junit.framework.TestCase;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;

/**
 * @Author Administrator
 * @create 2020/12/21 0021 0:22
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext.xml"})
public class UserDao1Test {
    @Autowired
    UserDao1 userDao1;
    @Test
    public void exist() {
        TestCase.assertTrue(userDao1.exist("root")>0);

    }

    @Test
    public void login() {
        User user=new User("root","1234");
        User login = userDao1.login(user);
        System.out.println(login);
    }
}