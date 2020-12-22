package com.abc.dao.entity;

/**
 * @Author Administrator
 * @create 2020/12/22 0022 14:55
 */
public class Course {
    private int cid;
    private String cname;

    public Course(int cid, String cname) {
        this.cid = cid;
        this.cname = cname;
    }

    public Course() {
    }

    public int getCid() {
        return cid;
    }

    public void setCid(int cid) {
        this.cid = cid;
    }

    public String getCname() {
        return cname;
    }

    public void setCname(String cname) {
        this.cname = cname;
    }

    @Override
    public String toString() {
        return "Course{" +
                "cid=" + cid +
                ", cname='" + cname + '\'' +
                '}';
    }
}
