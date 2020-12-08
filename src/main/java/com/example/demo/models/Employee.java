package com.example.demo.models;

public class Employee {
    private int emp_id;
    private String name;
    private String surname;
    private String mail;
    private String password;

    public Employee(int emp_id, String name, String surname, String mail, String password) {
        this.emp_id = emp_id;
        this.name = name;
        this.surname = surname;
        this.mail = mail;
        this.password = password;
    }

    public int getEmp_id() {
        return emp_id;
    }

    public void setEmp_id(int emp_id) {
        this.emp_id = emp_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
