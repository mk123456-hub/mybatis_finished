package com.abc.service.impl;

import com.abc.common.Res;
import com.abc.dao.entity.User;
import com.abc.service.iservice.IUserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;

/**
 * @Author Administrator
 * @create 2020/12/16 0016 14:41
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext.xml"})
public class UserServiceImplTest {
    @Autowired
    IUserService userService;

    @Test
    public void userExist() {
        Res root = null;
        try {
            root = userService.userExist("root");
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(root);
    }

    @Test
    public void login() {
        User user=new User("root","1234");
        try {
            System.out.println(userService.login(user));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}