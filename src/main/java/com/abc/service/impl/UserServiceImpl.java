package com.abc.service.impl;

import com.abc.common.Comm;
import com.abc.common.Res;
import com.abc.common.ResEnum;
import com.abc.dao.entity.User;
import com.abc.dao.idao.IUserDao;
import com.abc.service.iservice.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @Author Administrator
 * @create 2020/12/1 0001 21:28
 */
@Service("userService")
public class UserServiceImpl implements IUserService {
    @Autowired
    IUserDao iUserDao;

    @Override
    public Res userExist(String username) throws Exception{
        int flag=iUserDao.exist(username);
        return flag>0 ? Res.success(ResEnum.SUCCESS_USER_EXIST):Res.error(ResEnum.ERROR_USER_EXIST);
    }

    @Override
    public Res<User> login(User user) throws Exception{
        User result=iUserDao.login(user);
        if(result!=null){
            result.setPassword("");
            return Res.success(ResEnum.SUCCESS);
        }
        return Res.error(ResEnum.ERROR);
    }

}
