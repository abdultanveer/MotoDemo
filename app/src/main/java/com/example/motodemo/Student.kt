package com.example.motodemo;

public class Student {
    String name;
    int age;
    String address;
    int phno;

    public Student(String name, int age, String address, int phno) {
        this.name = name;
        this.age = age;
        this.address = address;
        this.phno = phno;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getPhno() {
        return phno;
    }

    public void setPhno(int phno) {
        this.phno = phno;
    }
}
