/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.student.beans;

/**
 *
 * @author dell
 */
public class StudentBean {
     private int id;
    private String Enrollment;
    private String name;
    private String email;
    private int p;
    private int h;
    private int e;
    private int m;
    private int c;
    private int per;
    private String status;

    public StudentBean() {
    }

    public StudentBean(int id, String Enrollment, String name, String email, int p, int h, int e, int m, int c, int per, String status) {
        this.id = id;
        this.Enrollment = Enrollment;
        this.name = name;
        this.email = email;
        this.p = p;
        this.h = h;
        this.e = e;
        this.m = m;
        this.c = c;
        this.per = per;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEnrollment() {
        return Enrollment;
    }

    public void setEnrollment(String Enrollment) {
        this.Enrollment = Enrollment;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getP() {
        return p;
    }

    public void setP(int p) {
        this.p = p;
    }

    public int getH() {
        return h;
    }

    public void setH(int h) {
        this.h = h;
    }

    public int getE() {
        return e;
    }

    public void setE(int e) {
        this.e = e;
    }

    public int getM() {
        return m;
    }

    public void setM(int m) {
        this.m = m;
    }

    public int getC() {
        return c;
    }

    public void setC(int c) {
        this.c = c;
    }

    public int getPer() {
        return per;
    }

    public void setPer(int per) {
        this.per = per;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
    
    
    
}