package com.abc.ssm.spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @Author Administrator
 * @create 2020/12/16 0016 13:10
 */
public class Test {
    public static void main(String[] args) {
        ApplicationContext app=new ClassPathXmlApplicationContext("applicationContext.xml");
        Person zhao = (Person) app.getBean("zhao");
        Phone phone = zhao.getPhone();
        System.out.println(zhao.getPname());
        System.out.println(phone);
    }
}
