package com.abc.dao.idao;

import com.abc.dao.entity.Dept;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Author Administrator
 * @create 2020/12/7 0007 15:25
 */
public interface DeptDao {
    List<Dept> findAll();
}
