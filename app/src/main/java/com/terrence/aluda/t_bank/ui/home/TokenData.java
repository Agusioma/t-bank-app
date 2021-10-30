package com.terrence.aluda.t_bank.ui.home;

public class TokenData {
    private String firstname, lastname, natID, email, userPassword, regDate;

    public TokenData(String firstname, String lastname, String email, String natID, String userPassword, String regDate) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.natID = natID;
        this.userPassword = userPassword;
        this.regDate = regDate;
        this.email = email;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setNatID(String natID) {
        this.natID = natID;
    }

    public String getNatID() {
        return natID;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    public void setRegDate(String regDate) {
        this.regDate = regDate;
    }

    public String getRegDate() {
        return regDate;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public String getUserPassword() {
        return userPassword;
    }
}
