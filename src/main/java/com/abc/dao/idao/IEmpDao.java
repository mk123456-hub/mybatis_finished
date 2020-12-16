package com.abc.dao.idao;

import com.abc.controller.vo.DelVO;
import com.abc.dao.entity.Emp;

import java.util.List;

/**
 * @Author Administrator
 * @create 2020/12/2 0002 22:13
 */
public interface IEmpDao {
    List<Emp> findByPage(int i, int size) throws Exception;
    List<Emp> findByName(String name) throws Exception;
    Emp findById(Integer id) throws Exception;

    void delete(Emp emp) throws Exception;
    void save(Emp emp) throws Exception;
    void update(Emp emp) throws Exception;

    void delBatch(List<DelVO> delVOList) throws Exception;
}
