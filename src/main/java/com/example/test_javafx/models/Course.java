package com.example.test_javafx.models;

import java.util.ArrayList;
import java.util.List;

public class Course {
    private String courseName;
private  String discribtion;
    private String textbook;
    private String instructor;
    private String classRoom;
    private String teatcherAssiment;
    private List<Lecture> lectures =new ArrayList<Lecture>();
    private ArrayList<Student> students=new ArrayList<Student>();

    //name,subject,textbook,teatcher,classroom
    public Course(String courseName, String discribtion, String textbook, String instructor,String teatcherAssiment, String virtualRoom, ArrayList<Lecture> lectures) {
        this.courseName = courseName;
        this.textbook = textbook;
        this.instructor = instructor;
        this.teatcherAssiment=teatcherAssiment;
        this.classRoom = virtualRoom;
        this.discribtion= discribtion;
        this.lectures= lectures;

    }
    public String toStringCsvCourse() {
        String toString = this.courseName + "," + this.discribtion + "," + this.textbook + "," + this.instructor + "," + this.teatcherAssiment + "," + this.classRoom;

        String st="";
        for(Student student :students ){
            st+=student.getUniversityId()+";";
        }
        return toString;
     }
    public String getCourseName() {
        return courseName;
    }



    public String getTextbook() {
        return textbook;
    }

    public String getInstructor() {
        return instructor;
    }

    public String getVirtualRoom() {
        return classRoom;
    }

    public List<Lecture> getLectures() {
        return lectures;
    }

    public void addLecture(Lecture lecture) {
        lectures.add(lecture);
    }
    public void removeLecture(Lecture lecture) {
        lectures.remove(lecture);
    }

    public ArrayList<Student> getStudents() {
        return students;
    }
    public void addStudent (Student student){
        students.add(student);
    }
    public void removeStudent(Student  student) {
        students.remove(student);
    }



    // Other methods as needed
}
