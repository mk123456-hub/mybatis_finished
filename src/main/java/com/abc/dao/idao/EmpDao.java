package com.abc.dao.idao;

import com.abc.controller.vo.DelVO;
import com.abc.dao.entity.Emp;
import org.apache.ibatis.annotations.Param;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * @Author Administrator
 * @create 2020/12/2 0002 22:13
 */
public interface EmpDao {
    List<Emp> findByPage(@Param("start") int start,@Param("size") int size);
    List<Emp> findByName(@Param("name") String name);
    Emp findById(@Param("id") Integer id);

//    int delete(@Param("id") Integer id) ;
    int delete(Emp emp);
    int save(Emp emp);
    int update(Emp emp);
    List<Emp> findByDeptno(@Param("deptno")Integer deptno);

    List<Emp> find(@Param("ename") String ename,@Param("hiredate") Date hiredate,@Param("sal") BigDecimal sal);

   int delBatch(List<Integer> ids);
   int saveBatch(List<Emp> emps);
   int dymicUpdateBatch(Emp emp);
}
