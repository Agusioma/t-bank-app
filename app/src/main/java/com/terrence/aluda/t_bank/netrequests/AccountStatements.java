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

    /*public AccountStatements(String trans_id, String trans_type, String trans_date,String amount){
        this.trans_id = trans_id;
        this.trans_type = trans_type;
        this.trans_date = trans_date;
        this.amount = amount;
    }*/

    public void setCustomerID(String customerID) {
        this.customerID = customerID;
    }

    public String getCustomerID() {
        return customerID;
    }

    public void setTransID(String transID) {
        this.transID = transID;
    }

    public String getTransID() {
        return transID;
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
