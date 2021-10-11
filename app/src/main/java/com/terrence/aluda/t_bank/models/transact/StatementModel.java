package com.terrence.aluda.t_bank.models.transact;

public class StatementModel {
    private String trans_id;
    private String trans_type;
    private String trans_date;
    private String amount;

    public StatementModel(String trans_id, String trans_type, String trans_date,String amount){
        this.trans_id = trans_id;
        this.trans_type = trans_type;
        this.trans_date = trans_date;
        this.amount = amount;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getTrans_date() {
        return trans_date;
    }

    public void setTrans_date(String trans_date) {
        this.trans_date = trans_date;
    }

    public String getTrans_id() {
        return trans_id;
    }

    public void setTrans_id(String trans_id) {
        this.trans_id = trans_id;
    }

    public String getTrans_type() {
        return trans_type;
    }

    public void setTrans_type(String trans_type) {
        this.trans_type = trans_type;
    }
}
