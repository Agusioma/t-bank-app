package com.terrence.aluda.t_bank.netrequests;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


public class TotalSavings {

    @SerializedName("totals")
    @Expose
    public String totals;

    public void setTotals(String totals) {
        this.totals = totals;
    }

    public String getTotals() {
        return totals;
    }
}
