package com.abc.service.impl;

import com.abc.common.Comm;
import com.abc.common.Res;
import com.abc.common.ResEnum;
import com.abc.dao.entity.Dept;
import com.abc.dao.factory.DaoFactory;
import com.abc.dao.idao.IDeptDao;
import com.abc.service.iservice.IDeptService;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author Administrator
 * @create 2020/12/7 0007 15:24
 */
public class DeptServiceImpl implements IDeptService {
    IDeptDao deptDao;

    public DeptServiceImpl() {
        deptDao= (IDeptDao) DaoFactory.getInstance(Comm.DEPT);
    }

    @Override
    public Res<List<Dept>> findAll() throws Exception {
        List<Dept> result=new ArrayList<>();
        result=deptDao.findAll();
        return (result!=null&&result.size()>0) ? Res.success(ResEnum.SUCCESS,result):Res.error();
    }
}
