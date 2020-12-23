package com.abc.dao.entity;

import java.util.List;

/**
 * @Author Administrator
 * @create 2020/12/22 0022 13:43
 */
public class Student {
    private int sid;
    private int did;
    private String sname;

    public Student(int sid, int did, String sname) {
        this.sid = sid;
        this.did = did;
        this.sname = sname;
    }

    public Student() {
    }

    public int getSid() {
        return sid;
    }

    public void setSid(int sid) {
        this.sid = sid;
    }

    public int getDid() {
        return did;
    }

    public void setDid(int did) {
        this.did = did;
    }

    public String getSname() {
        return sname;
    }

    public void setSname(String sname) {
        this.sname = sname;
    }

    @Override
    public String toString() {
        return "Student{" +
                "sid=" + sid +
                ", did=" + did +
                ", sname='" + sname + '\'' +
                '}';
    }
}
