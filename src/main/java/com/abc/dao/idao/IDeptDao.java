package com.abc.dao.idao;

import com.abc.dao.entity.Dept;

import java.util.List;

/**
 * @Author Administrator
 * @create 2020/12/7 0007 15:25
 */
public interface IDeptDao {
    List<Dept> findAll() throws Exception;
}
