/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package spr.beans;

/**
 *
 * @author deshp
 */
public class Student {
    private int rollNo;
    private String name;
    private int age;
    private String phoneNo;
    private int marks;
    private String subject;

    public Student() {
    }

    public Student(int rollNo, String name, int age, String phoneNo, int marks, String subject) {
        this.rollNo = rollNo;
        this.name = name;
        this.age = age;
        this.phoneNo = phoneNo;
        this.marks = marks;
        this.subject = subject;
    }

    @Override
    public String toString() {
        return "Student{" + "rollNo=" + rollNo + ", name=" + name + ", age=" + age + ", phoneNo=" + phoneNo + ", marks=" + marks + ", subject=" + subject + '}';
    }
    
    

    public int getRollNo() {
        return rollNo;
    }

    public void setRollNo(int rollNo) {
        this.rollNo = rollNo;
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

    public String getPhoneNo() {
        return phoneNo;
    }

    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
    }

    public int getMarks() {
        return marks;
    }

    public void setMarks(int marks) {
        this.marks = marks;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }
    
    
}
