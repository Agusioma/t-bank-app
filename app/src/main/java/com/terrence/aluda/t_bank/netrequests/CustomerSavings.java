package com.terrence.aluda.t_bank.netrequests;

import com.google.gson.annotations.SerializedName;

public class CustomerSavings {

    @SerializedName("id")
    public Integer id;
    @SerializedName("customerID")
    public String customerID;
    @SerializedName("currYear")
    public String currYear;
    @SerializedName("january")
    public String january;
    @SerializedName("february")
    public String february;
    @SerializedName("march")
    public String march;
    @SerializedName("april")
    public String april;
    @SerializedName("may")
    public String may;
    @SerializedName("june")
    public String june;
    @SerializedName("july")
    public String july;
    @SerializedName("august")
    public String august;
    @SerializedName("september")
    public String september;
    @SerializedName("october")
    public String october;
    @SerializedName("november")
    public String november;
    @SerializedName("december")
    public String december;

    public Integer getId() {
        return id;
    }

    public String getCustomerID() {
        return customerID;
    }

    public String getCurrYear() {
        return currYear;
    }

    public void setCurrYear(String currYear) {
        this.currYear = currYear;
    }

    public String getJanuary() {
        return january;
    }

    public void setJanuary(String january) {
        this.january = january;
    }

    public String getFebruary() {
        return february;
    }

    public void setFebruary(String february) {
        this.february = february;
    }

    public String getMarch() {
        return march;
    }

    public void setMarch(String march) {
        this.march = march;
    }

    public String getApril() {
        return april;
    }

    public void setApril(String april) {
        this.april = april;
    }

    public String getMay() {
        return may;
    }

    public void setMay(String may) {
        this.may = may;
    }

    public String getJune() {
        return june;
    }

    public void setJune(String june) {
        this.june = june;
    }

    public String getJuly() {
        return july;
    }

    public void setJuly(String july) {
        this.july = july;
    }

    public String getAugust() {
        return august;
    }

    public void setAugust(String august) {
        this.august = august;
    }

    public String getSeptember() {
        return september;
    }

    public void setSeptember(String september) {
        this.september = september;
    }

    public String getOctober() {
        return october;
    }

    public void setOctober(String october) {
        this.october = october;
    }

    public String getNovember() {
        return november;
    }

    public void setNovember(String november) {
        this.november = november;
    }

    public String getDecember() {
        return december;
    }

    public void setDecember(String december) {
        this.december = december;
    }
}
