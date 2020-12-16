package com.abc.controller;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringIOC {
    public static ApplicationContext getSpring(){
        return new ClassPathXmlApplicationContext("applicationContext.xml");
    }
}
