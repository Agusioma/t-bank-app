package com.terrence.aluda.t_bank.netrequests;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class DefaultResponse {
    @SerializedName("response")
    @Expose
    public String responseString;

    public void setOK(String token) {
        this.responseString = token;
    }

    public String getOK() {
        return responseString;
    }
}
