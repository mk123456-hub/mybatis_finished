package com.abc.dao.idao;

import com.abc.controller.vo.DeptEmpVO;
import com.abc.service.dto.DeptEmpDTO;

import java.util.List;

/**
 * @Author Administrator
 * @create 2020/12/7 0007 21:23
 */
public interface ReportDao {
    List<DeptEmpDTO> makeReportForDeptEmp(DeptEmpVO deptEmpVO);
}
