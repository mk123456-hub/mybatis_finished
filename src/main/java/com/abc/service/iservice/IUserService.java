package com.abc.service.iservice;

import com.abc.common.Res;
import com.abc.dao.entity.User;

/**
 * @Author Administrator
 * @create 2020/12/1 0001 21:21
 */
public interface IUserService {
    Res userExist(String username) throws Exception;

    Res<User> login(User user) throws Exception;
}
