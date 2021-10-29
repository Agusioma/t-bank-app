package com.terrence.aluda.t_bank.login;

import com.google.gson.annotations.SerializedName;
public class LoginTest {
    @SerializedName("id")
    public Integer id;
    @SerializedName("NatID")
    public String natID;
    @SerializedName("firstname")
    public String firstname;
    @SerializedName("lastname")
    public String lastname;
    @SerializedName("email")
    public String email;
    @SerializedName("PhoneNo")
    public String phoneNo;
    @SerializedName("regDate")
    public String regDate;
    @SerializedName("password")
    public String password;

    public void setId(Integer id) {
        this.id = id;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public void setNatID(String natID) {
        this.natID = natID;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
    }

    public void setRegDate(String regDate) {
        this.regDate = regDate;
    }

    public Integer getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public String getFirstname() {
        return firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public String getNatID() {
        return natID;
    }

    public String getPassword() {
        return password;
    }

    public String getPhoneNo() {
        return phoneNo;
    }

    public String getRegDate() {
        return regDate;
    }
}