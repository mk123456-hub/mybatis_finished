package com.abc.dao.entity;

/**
 * @Author Administrator
 * @create 2020/12/7 0007 15:21
 */
public class Dept {
    private int deptno;
    private String dname;
    private String loc;

    public Dept(int deptno, String dname) {
        this.deptno = deptno;
        this.dname = dname;
    }

    public int getDeptno() {
        return deptno;
    }

    public void setDeptno(int deptno) {
        this.deptno = deptno;
    }

    public String getDname() {
        return dname;
    }

    public void setDname(String dname) {
        this.dname = dname;
    }

    public String getLoc() {
        return loc;
    }

    public void setLoc(String loc) {
        this.loc = loc;
    }
}
