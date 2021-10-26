package com.terrence.aluda.t_bank.login;

import com.google.gson.annotations.SerializedName;
public class LoginTest {
    @SerializedName("id")
    public Integer id;
    @SerializedName("NatID")
    public Integer natID;
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

}