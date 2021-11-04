package com.terrence.aluda.t_bank.netrequests;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


public class TotalSavings {

    @SerializedName("totals")
    @Expose
    public Integer totals;

    public void setTotals(Integer totals) {
        this.totals = totals;
    }

    public Integer getTotals() {
        return totals;
    }
}
