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

    private Dept1 dept1;

    private List<Score> scores;

    public Student() {
    }

    public Student(int sid, int did, String sname, Dept1 dept1, List<Score> scores) {
        this.sid = sid;
        this.did = did;
        this.sname = sname;
        this.dept1 = dept1;
        this.scores = scores;
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

    public Dept1 getDept1() {
        return dept1;
    }

    public void setDept1(Dept1 dept1) {
        this.dept1 = dept1;
    }

    public List<Score> getScores() {
        return scores;
    }

    public void setScores(List<Score> scores) {
        this.scores = scores;
    }

    @Override
    public String toString() {
        return "Student{" +
                "sid=" + sid +
                ", did=" + did +
                ", sname='" + sname + '\'' +
                ", dept1=" + dept1 +
                ", scores=" + scores +
                '}';
    }
}
