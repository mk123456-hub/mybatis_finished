package com.abc.service.iservice;

import com.abc.common.Res;
import com.abc.controller.vo.DeptEmpVO;
import com.abc.service.dto.DeptEmpDTO;

import java.util.List;

/**
 * @Author Administrator
 * @create 2020/12/7 0007 21:20
 */
public interface IReportService {
    Res<List<DeptEmpDTO>> makeReportForDeptEmp(DeptEmpVO deptEmpVO);
}
