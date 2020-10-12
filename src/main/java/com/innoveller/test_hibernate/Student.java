package com.innoveller.test_hibernate;
public class Student {
    private int id;
    private String name;
    private String rollNo;
    private String phoneNo;
    private String email;

    public Student() {}

    public Student( String name, String rollNo, String phoneNo, String email) {
        this.name = name;
        this.rollNo = rollNo;
        this.phoneNo = phoneNo;
        this.email = email;
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

    public String getRollNo() {
        return rollNo;
    }

    public void setRollNo(String rollNo) {
        this.rollNo = rollNo;
    }

    public String getPhoneNo() {
        return phoneNo;
    }

    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
