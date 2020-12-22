package com.abc.dao.entity;

/**
 * @Author Administrator
 * @create 2020/12/22 0022 13:45
 */
public class Dept1 {
    private int did;
    private String dname;

    public Dept1(int did, String dname) {
        this.did = did;
        this.dname = dname;
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

    @Override
    public String toString() {
        return "Dept1{" +
                "did=" + did +
                ", dname='" + dname + '\'' +
                '}';
    }
}
