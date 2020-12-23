package com.abc.dao.entity;

import java.util.List;

/**
 * @Author Administrator
 * @create 2020/12/22 0022 13:45
 */
public class Dept1 {
    private int did;
    private String dname;

    private List<Student> stus;

    public Dept1(int did, String dname, List<Student> stus) {
        this.did = did;
        this.dname = dname;
        this.stus = stus;
    }

    public Dept1() {
    }

    public int getDid() {
        return did;
    }

    public void setDid(int did) {
        this.did = did;
    }

    public String getDname() {
        return dname;
    }

    public void setDname(String dname) {
        this.dname = dname;
    }

    public List<Student> getStus() {
        return stus;
    }

    public void setStus(List<Student> stus) {
        this.stus = stus;
    }

    @Override
    public String toString() {
        return "Dept1{" +
                "did=" + did +
                ", dname='" + dname + '\'' +
                ", stus=" + stus.size() +
                '}';
    }
}
