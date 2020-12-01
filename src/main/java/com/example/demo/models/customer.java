package com.example.demo.models;

public class customer {
    private String name;
    private int cvrnr;
    private String mail;
    private String password;

    public customer(String name, int cvrnr, String mail, String password) {
        this.name = name;
        this.cvrnr = cvrnr;
        this.mail = mail;
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCvrnr() {
        return cvrnr;
    }

    public void setCvrnr(int cvrnr) {
        this.cvrnr = cvrnr;
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
