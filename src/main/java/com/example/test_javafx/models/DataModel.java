package com.example.test_javafx.models;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;

public class DataModel {
    private static  String whoTeatcher;
    private int index ;
    private static ArrayList<Student> students =new ArrayList<Student>();
    private static ArrayList<Teatcher> teatchers = new ArrayList<Teatcher>();
    private static ArrayList<Course> courses =new ArrayList<Course>();


    public DataModel() {
initialize();
    }

    public static void initialize() {
        if (students.isEmpty()) {
            File file = new File("Student.csv");
            if (file.exists()) {
                try  {
                    Scanner scanner = new Scanner(file);
                    //read header line

                    while (scanner.hasNext()) {

                        String[] strings = scanner.nextLine().split(", ");
                       students.add(new Student(strings[0], strings[1], strings[2],strings[3],Float.parseFloat(strings[4])));
                    }
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }
            }
            else {
                // add Test data when you run the program for the first time
                students.add(new Student("Student 1", "120210994", "0599480220", "gaza", 95f));
                students.add(new Student("Student 2", "120210994", "0599480220", "gaza", 95f));
                students.add(new Student("Student 3", "120210994", "0599480220", "gaza", 95f));
                students.add(new Student("Student 4", "120210994", "0599480220", "gaza", 95f));
            }
        }

        if (teatchers.isEmpty()) {
            File file = new File("project60\\teatchers.csv");
            if (file.exists()) {
                System.out.println("yes");
                try  {
                    Scanner scanner = new Scanner(file);
                    //read header line


                    String[] strings = scanner.nextLine().split(",");

                    while (scanner.hasNext()) {

                         strings = scanner.nextLine().split(",");
                        teatchers.add(new Teatcher(strings[0], strings[1], strings[2],strings[3]));
                        System.out.println("hello");
                    }
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }
            }
            System.out.println("ssss");

        }
        if (courses.isEmpty()) {
            File file = new File("courses.csv");
            if (file.exists()) {
                try  {
                    Scanner scanner = new Scanner(file);
                    //read header line


                    String[] strings = scanner.nextLine().split(",");


                    while (scanner.hasNext()) {

                        strings = scanner.nextLine().split(",");
                        //String courseName,  String textbook, String instructor,String teatcherAssiment, String virtualRoom
                       //courses.add(new Course(strings[0], strings[1], strings[2],strings[3],strings[4],strings[5]));
                    }
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }
            }

        }
    }

    public static ArrayList<Teatcher> getTeatchers() {
        return teatchers;
    }
    public static void addTeatcher(Teatcher teatcher){
        teatchers.add(teatcher);
    }

    public static void deleteTeatcherByUsername(String name){
        for(int i =0; i<teatchers.size();i++) {
            if (Objects.equals(teatchers.get(i).getUsername(), name)) {
                teatchers.remove(i);
            }
        }
    }
public int getIndexByUsername(String username) {
        int index=-1 ;
    for(int i =0; i<teatchers.size();i++) {
        if (Objects.equals(teatchers.get(i).getUsername(), username)) {
            index = i ;
        }

    }
    return index;
}
    public boolean varUserName(String userName){
        boolean torf=false;
        for(int i=0;i<teatchers.size();i++){
            if(userName.equals(teatchers.get(i).getUsername())){
                index=i;
                torf =true;
            }
        }
        return torf;    }
    public boolean isManeger(String userName,String pass,User u) {
        boolean torf = false;
        if ((userName.equals(u.getUsername())) && (pass.equals(u.getPassword()))) {
            torf = true;

        } else torf = false;
        return torf;
    }


    public boolean varPassword(String pass){

        return pass.equals(teatchers.get(index).getPassword());
    }

    public void setWhoTeatcher(String whoTeatcher) {
        this.whoTeatcher = whoTeatcher;
    }

    public void wohTeatcher(String userName){
        setWhoTeatcher(userName);
}
public String getWhoTeatcher(){
        return whoTeatcher;
}
    public void saveTeatchers() {
        try (PrintWriter pw = new PrintWriter("teatchers.csv")) {
            //print header line
            pw.println("name, username,password,phone,course");
            for (int i=0;i<teatchers.size();i++) {
                //print each student object as string
                Teatcher teatcher =teatchers.get(i);
                pw.println(teatcher.toStringCsv());
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
    public static ArrayList<Course> getCourses() {
        return courses;
    }
    public static void addCourses(Course course){
        courses.add(course);
    }
    public static void deleteCourses(Course course){
       courses.remove(course);
    }
  public int getindexCourseByname(String courseName){
      int indexCourse = -1;
    for (int i= 0; i<courses.size(); i++){

        if((courses.get(i).getCourseName()).equals(courseName)){
            indexCourse=i;

        }

    }
    return indexCourse;
    }


    public void saveCourse()
    {
        try (PrintWriter pw = new PrintWriter("courses.csv")) {
            //print header line
            //name,subject,textbook,teatcher,classroom
            pw.println("name,discription,textbook,teatcher,teatcherAssiment,classroom");
            for (int i=0;i<courses.size();i++) {
                //print each student object as string
                Course course =courses.get(i);
                pw.println(course.toStringCsvCourse());
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void save_Students()
    {
        try (PrintWriter pw = new PrintWriter("students.csv")) {
            //print header line
            pw.println("name, universityId, phoneNumber, residenceArea, gpa");
            for (Student s : students) {
                //print each student object as string
                pw.println(s.toString());
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void addStudent(Student student) {
        students.add(student);
    }

    public Student getStudentByName(String name) {
        for (Student student : students) {
            if (Objects.equals(student.getName(), name)) {
                return student;
            }
        }
        return null;
    }



    public ArrayList<Student> getStudents() {
        return students;
    }

    public Student deleteStudentByName(String name) {
        for (Student student : students) {
            if (Objects.equals(student.getName(), name)) {
                students.remove(student);
                return student;
            }
        }
        return null;
    }
}
