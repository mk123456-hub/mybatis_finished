package com.abc.dao.entity;

import java.math.BigDecimal;

/**
 * @Author Administrator
 * @create 2020/12/22 0022 14:53
 */
public class Score {
    private int scid;
    private int sid;
    private int cid;
    private int score;
    private Course course;

    public Score(int scid, int sid, int cid, int score, Course course) {
        this.scid = scid;
        this.sid = sid;
        this.cid = cid;
        this.score = score;
        this.course = course;
    }

    public Score() {
    }

    public int getScid() {
        return scid;
    }

    public void setScid(int scid) {
        this.scid = scid;
    }

    public int getSid() {
        return sid;
    }

    public void setSid(int sid) {
        this.sid = sid;
    }

    public int getCid() {
        return cid;
    }

    public void setCid(int cid) {
        this.cid = cid;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    @Override
    public String toString() {
        return "Score{" +
                "scid=" + scid +
                ", sid=" + sid +
                ", cid=" + cid +
                ", score=" + score +
                ", course=" + course +
                '}';
    }
}
