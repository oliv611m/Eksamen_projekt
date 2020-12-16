package com.example.demo.models;

public class Corporation {
    private String name;
    private int cvr_no;
    private String email;
    private String password;
    private int corpID;

    public Corporation(String name, int cvr_no, String email, String password, int corpID) {
        this.name = name;
        this.cvr_no = cvr_no;
        this.email = email;
        this.password = password;
        this.corpID = corpID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCvr_no() {
        return cvr_no;
    }

    public void setCvr_no(int cvr_no) {
        this.cvr_no = cvr_no;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getCorpID(){return corpID;}

    public void setCorpID(int corpID) {
        this.corpID = corpID;
    }
}
