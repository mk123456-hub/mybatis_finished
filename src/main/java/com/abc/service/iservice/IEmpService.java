package com.abc.service.iservice;

import com.abc.common.Res;
import com.abc.controller.vo.DelVO;
import com.abc.dao.entity.Emp;

import java.util.List;

/**
 * @Author Administrator
 * @create 2020/12/2 0002 21:57
 */
public interface IEmpService {
    List<Emp> findByPage(int page, int size) throws Exception;
    List<Emp> findByName(String name) throws Exception;
    Emp findById(Integer id) throws Exception;

    String delete(Emp emp) throws Exception;
    String save(Emp emp) throws Exception;
    String update(Emp emp) throws Exception;

    Res delBatch(List<DelVO> delVOList);
}
