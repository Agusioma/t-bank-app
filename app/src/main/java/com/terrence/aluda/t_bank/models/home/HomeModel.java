package com.terrence.aluda.t_bank.models.home;

public class HomeModel {
    private String course_name;


    // Constructor
    public HomeModel(String course_name) {
        this.course_name = course_name;
    }

    // Getter and Setter
    public String getCourse_name() {
        return course_name;
    }

    public void setCourse_name(String course_name) {
        this.course_name = course_name;
    }
}
