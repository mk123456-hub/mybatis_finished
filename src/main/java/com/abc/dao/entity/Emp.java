package com.abc.dao.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * @Author Administrator
 * @create 2020/12/2 0002 22:00
 */

public class Emp implements Serializable {
    private int empno;
    private String ename;
    private Date hiredate;
    private BigDecimal sal;

    public Emp(String ename, Date hiredate, BigDecimal sal) {
        this.ename = ename;
        this.hiredate = hiredate;
        this.sal = sal;
    }

    public Emp(int empno, String ename, Date hiredate, BigDecimal sal) {
        this.empno = empno;
        this.ename = ename;
        this.hiredate = hiredate;
        this.sal = sal;
    }

    public Emp() {
    }

    public int getEmpno() {
        return empno;
    }

    public void setEmpno(int empno) {
        this.empno = empno;
    }

    public String getEname() {
        return ename;
    }

    public void setEname(String ename) {
        this.ename = ename;
    }

    public Date getHiredate() {
        return hiredate;
    }

    public void setHiredate(Date hiredate) {
        this.hiredate = hiredate;
    }

    public BigDecimal getSal() {
        return sal;
    }

    public void setSal(BigDecimal sal) {
        this.sal = sal;
    }

    @Override
    public String toString() {
        return "Emp{" +
                "empno=" + empno +
                ", ename='" + ename + '\'' +
                ", hiredate=" + hiredate +
                ", sal=" + sal +
                '}';
    }
}
