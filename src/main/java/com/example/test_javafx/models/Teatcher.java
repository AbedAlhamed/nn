package com.example.test_javafx.models;

import java.util.ArrayList;

public class Teatcher extends User {
    private ArrayList<String> course = new ArrayList<String>();
    private String phone;
    private String name;

    public String getName() {
        return name;
    }

    //name,username,password,phone,course
    public Teatcher(String name ,String username, String password, String phone) {
        super(username, password);
        this.phone=phone;
        this.name=name;
    }

    public String toStringCsv() {
        return this.name+","+this.getUsername()+","+this.getPassword()+","+this.phone;
    }

    public ArrayList<String> getCourse() {
        return course;
    }

    public void addLecture(String title, String location) {
        // Code to add a new lecture to the instructor's course
    }

    public void editLecture(String title, String newLocation) {
        // Code to edit an existing lecture of the instructor's course
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void addCourse(String course) {
        this.course.add(course) ;
    }

    public void recordAttendance(String studentId, boolean present) {
        // Code to record attendance of a student in the instructor's course
    }

    public void importAttendance(String filePath) {
        // Code to import attendance from a file for the instructor's course
    }

    public void generateAttendanceReport() {
        // Code to generate the attendance report for the instructor's course
    }
}
