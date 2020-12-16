package com.abc.service.impl;

import com.abc.common.Comm;
import com.abc.common.Res;
import com.abc.common.ResEnum;
import com.abc.controller.vo.DelVO;
import com.abc.dao.entity.Emp;
import com.abc.dao.idao.IEmpDao;
import com.abc.service.iservice.IEmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author Administrator
 * @create 2020/12/2 0002 22:11
 */
@Service("empService")
public class EmpServiceImpl implements IEmpService {
    @Autowired
    IEmpDao empDao;

    @Override
    public List<Emp> findByPage(int page, int size) {
        List<Emp>  emps=null;
        try {
            emps=empDao.findByPage((page-1)*size,size);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return emps;
    }

    @Override
    public List<Emp> findByName(String name) throws Exception{
        List<Emp>  emps=null;
        try {
            emps=empDao.findByName(name);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return emps;
    }

    @Override
    public Emp findById(Integer id) throws Exception{
        Emp emp=null;
        try {
            emp=empDao.findById(id);
        }catch (Exception e){
            e.printStackTrace();
        }
        return emp;
    }

    @Override
    public String delete(Emp emp) throws Exception{
        String msg=Comm.ERROR;
        try {
            empDao.delete(emp);
            msg=Comm.SUCCESS;
        }catch (Exception e){

        }
        return msg;
    }

    @Override
    public String save(Emp emp) throws Exception{
        String msg=Comm.ERROR;
        try {
            empDao.save(emp);
            msg=Comm.SUCCESS;
        }catch (Exception e){

        }
        return msg;
    }

    @Override
    public String update(Emp emp) throws Exception{
        String msg=Comm.ERROR;
        try {
            empDao.update(emp);
            msg=Comm.SUCCESS;
        }catch (Exception e){

        }
        return msg;
    }

    @Override
    public Res delBatch(List<DelVO> delVOList) {
        if(delVOList==null&&delVOList.size()==0){
            return Res.error(ResEnum.ERROR_PARAMS_IN_DELBATCH);
        }
        try {
            empDao.delBatch(delVOList);
            return Res.success(ResEnum.SUCCESS_DEL_BATCH);
        }catch (Exception e){
            e.printStackTrace();
        }
        return Res.error();
    }
}
