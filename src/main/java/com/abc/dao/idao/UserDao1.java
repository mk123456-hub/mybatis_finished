package com.abc.dao.idao;

import com.abc.dao.entity.User;
import org.apache.ibatis.annotations.Param;

/**
 * @Author Administrator
 * @create 2020/12/1 0001 21:32
 */
public interface UserDao1 {
    int exist(@Param("username") String username);

    User login(User user);
}
