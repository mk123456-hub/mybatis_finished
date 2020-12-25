package com.abc.service.impl;

import com.abc.common.Comm;
import com.abc.common.Res;
import com.abc.common.ResEnum;
import com.abc.controller.vo.DelVO;
import com.abc.dao.entity.Emp;
import com.abc.dao.idao.EmpDao;
import com.abc.service.iservice.IEmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service("empService")
public class EmpServiceImpl implements IEmpService {
    @Autowired
    EmpDao empDao;


    @Override
    public List<Emp> findByPage(int page, int size) {
        List<Emp> emps = null;
        try {
            emps = empDao.findByPage((page - 1) * size, size);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return emps;
    }

    @Override
    public List<Emp> findByName(String ename) {
        List<Emp> emps = null;
        try {
            emps = empDao.findByName(ename);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return emps;
    }

    @Override
    public Emp findById(Integer empno) {
        Emp emp = null;
        try {
            emp = empDao.findById(empno);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return emp;
    }

    @Override
    public String delete(Emp emp) {
        int flag=empDao.delete(emp);
        return flag>0 ? Comm.SUCCESS:Comm.ERROR;
    }

    @Override
    public String save(Emp emp) {
        int flag=empDao.save(emp);
        return flag>0 ? Comm.SUCCESS:Comm.ERROR;
    }
    public String update(Emp emp) {
        int flag=empDao.update(emp);
        return flag>0 ? Comm.SUCCESS:Comm.ERROR;
    }

    @Override
    public Res<List<Emp>> findByDeptno(int deptno) {
        List<Emp> emps = null;
        try {
            emps = empDao.findByDeptno(deptno);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return (emps != null && emps.size() > 0) ? Res.success(ResEnum.SUCCESS, emps) : Res.error();
    }

    @Override
    public Res delBatch(List<DelVO> delVOList) {
        if(delVOList==null || delVOList.size()==0){
            return Res.error(ResEnum.ERROR_PARAMS_IN_DELBATCH);
        }
        int flag = empDao.delBatch(delVOList.stream().map(x -> x.getEmpno()).collect(Collectors.toList()));
        return flag>0 ? Res.success(ResEnum.SUCCESS_DEL_BATCH):Res.error();
    }

    @Override
    public Res saveBatch(List<Emp> emps) {
        if(emps==null || emps.size()==0){
            return Res.error(ResEnum.ERROR_PARAMS_IN_SAVEBATCH);
        }
        int flag = empDao.saveBatch(emps);
        return flag>0 ? Res.success(ResEnum.SUCCESS_SAVE_BATCH):Res.error();
    }

    @Override
    public Res dymicUpdateBatch(Emp emp) {
        if(emp==null){
            return Res.error(ResEnum.ERROR_PARAMS_IN_UPDATEBATCH);
        }
        int flag = empDao.dymicUpdateBatch(emp);
        return flag>0 ? Res.success(ResEnum.SUCCESS_UPDATE_BATCH):Res.error();
    }


//    @Transactional(isolation = Isolation.READ_COMMITTED,propagation = Propagation.REQUIRED)
//    @Override
//    public Res delBatch(List<DelVO> delVOList) {
//        if(delVOList == null || delVOList.size() == 0){
//            return Res.error(ResEnum.ERROR_PARAMS_IN_DELBATCH);
//        }
//        try {
//            empDao.delBatch(delVOList);
//            return Res.success(ResEnum.SUCCESS_DEL_BATCH);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return Res.error();
//    }
}

