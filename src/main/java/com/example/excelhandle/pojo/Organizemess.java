package com.example.excelhandle.pojo;

public class Organizemess {
    private int id;
    //姓名
    private String name;
    //一级部门
    private String firstDept;
    //二级部门
    private String secondDept;
    //岗位
    private String postion;
    //岗位描述
    private String postionDescribtion;
    //手机号
    private String phone;


    public Organizemess() {
    }

    public Organizemess(int id, String name, String firstDept, String secondDept, String postion, String postionDescribtion, String phone) {
        this.id = id;
        this.name = name;
        this.firstDept = firstDept;
        this.secondDept = secondDept;
        this.postion = postion;
        this.postionDescribtion = postionDescribtion;
        this.phone = phone;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFirstDept() {
        return firstDept;
    }

    public void setFirstDept(String firstDept) {
        this.firstDept = firstDept;
    }

    public String getSecondDept() {
        return secondDept;
    }

    public void setSecondDept(String secondDept) {
        this.secondDept = secondDept;
    }

    public String getPostion() {
        return postion;
    }

    public void setPostion(String postion) {
        this.postion = postion;
    }

    public String getPostionDescribtion() {
        return postionDescribtion;
    }

    public void setPostionDescribtion(String postionDescribtion) {
        this.postionDescribtion = postionDescribtion;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
