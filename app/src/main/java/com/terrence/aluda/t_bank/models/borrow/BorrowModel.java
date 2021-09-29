package com.terrence.aluda.t_bank.models.borrow;

public class BorrowModel {
    private int image_id;
    private String first_label;

    // Constructor
    public BorrowModel(String first_label, int image_id) {
        this.first_label = first_label;
        this.image_id = image_id;
    }

    // Getter and Setter
    public int getImage_id() {
        return image_id;
    }

    public void setImage_id(int image_id) {
        this.image_id = image_id;
    }

    public String getFirst_label() {
        return first_label;
    }

    public void setFirst_label(String first_label) {
        this.first_label = first_label;
    }
}
