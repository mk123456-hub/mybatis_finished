package com.abc.service.impl;

import com.abc.common.Comm;
import com.abc.common.Res;
import com.abc.common.ResEnum;
import com.abc.dao.entity.Dept;
import com.abc.dao.idao.IDeptDao;
import com.abc.service.iservice.IDeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author Administrator
 * @create 2020/12/7 0007 15:24
 */
@Service("deptService")
public class DeptServiceImpl implements IDeptService {
    @Autowired
    IDeptDao deptDao;

    @Override
    public Res<List<Dept>> findAll() throws Exception {
        List<Dept> result=new ArrayList<>();
        result=deptDao.findAll();
        return (result!=null&&result.size()>0) ? Res.success(ResEnum.SUCCESS,result):Res.error();
    }
}
