package com.terrence.aluda.t_bank.netrequests;

import com.google.gson.annotations.SerializedName;

public class AccountStatements {

    @SerializedName("id")
    public Integer id;

    @SerializedName("customerID")
    public String customerID;

    @SerializedName("transID")
    public String transID;

    @SerializedName("transType")
    public String transType;

    @SerializedName("amount")
    public String amount;

    @SerializedName("transDate")
    public String transDate;

    public void setCustomerID(String customerID) {
        this.customerID = customerID;
    }

    public String getCustomerID() {
        return customerID;
    }

    public void setTransID(String transID) {
        this.transID = transID;
    }

    public String getTransType() {
        return transType;
    }

    public void setTransType(String transType) {
        this.transType = transType;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getTransDate() {
        return transDate;
    }

    public void setTransDate(String transDate) {
        this.transDate = transDate;
    }
}
