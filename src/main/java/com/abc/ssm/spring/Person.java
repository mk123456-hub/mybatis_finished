package com.abc.ssm.spring;

/**
 * @Author Administrator
 * @create 2020/12/16 0016 12:59
 */
public class Person {
    private int pid;
    private String pname;
    private Phone phone;

    public Person() {
    }

    public Person(int pid, String pname, Phone phone) {
        this.pid = pid;
        this.pname = pname;
        this.phone = phone;
    }

    public int getPid() {
        return pid;
    }

    public void setPid(int pid) {
        this.pid = pid;
    }

    public String getPname() {
        return pname;
    }

    public void setPname(String pname) {
        this.pname = pname;
    }

    public Phone getPhone() {
        return phone;
    }

    public void setPhone(Phone phone) {
        this.phone = phone;
    }

    @Override
    public String toString() {
        return "Person{" +
                "pid=" + pid +
                ", pname='" + pname + '\'' +
                ", phone=" + phone +
                '}';
    }
}
