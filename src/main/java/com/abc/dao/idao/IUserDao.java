package com.abc.dao.idao;

import com.abc.dao.entity.User;

/**
 * @Author Administrator
 * @create 2020/12/1 0001 21:32
 */
public interface IUserDao {
    int exist(String username) throws Exception;

    User login(User user) throws Exception;
}
