package com.abc.service.iservice;

import com.abc.common.Res;
import com.abc.dao.entity.Dept;

import java.util.List;

/**
 * @Author Administrator
 * @create 2020/12/7 0007 15:19
 */
public interface IDeptService {
    Res<List<Dept>> findAll() throws Exception;
}
