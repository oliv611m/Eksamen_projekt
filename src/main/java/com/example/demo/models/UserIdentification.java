//Oliver
package com.example.demo.models;

public class UserIdentification {
    private String cookieID;
    private int corpID;
    private boolean empID;

    public UserIdentification(String cookieID, int corpID, boolean empID) {
        this.cookieID = cookieID;
        this.empID = empID;
        this.corpID = corpID;
    }

    public String getCookieID() {
        return cookieID;
    }

    public void setCookieID(String cookieID) {
        this.cookieID = cookieID;
    }

    public int getCorpID() {
        return corpID;
    }

    public void setCorpID(int CorpID) {
        this.corpID = corpID;
    }

    public boolean isEmpID() {
        return empID;
    }

    public void setEmpID(boolean empID) {
        this.empID = empID;
    }
}
