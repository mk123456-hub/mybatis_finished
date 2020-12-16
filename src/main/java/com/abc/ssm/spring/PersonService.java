package com.abc.ssm.spring;

/**
 * @Author Administrator
 * @create 2020/12/16 0016 13:32
 */

public class PersonService {
    private PersonDao personDao;
    public void print(){
        personDao.print();
    }
}
