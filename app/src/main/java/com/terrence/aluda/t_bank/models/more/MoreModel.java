package com.terrence.aluda.t_bank.models.more;

public class MoreModel {
    private int image_id;
    private String first_label;
    private String second_label;

    // Constructor
    public MoreModel(String first_label, String second_label, int image_id) {
        this.first_label = first_label;
        this.second_label = second_label;
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

    public String getSecond_label() {
        return second_label;
    }

    public void setSecond_label(String second_label) {
        this.second_label = second_label;
    }
}