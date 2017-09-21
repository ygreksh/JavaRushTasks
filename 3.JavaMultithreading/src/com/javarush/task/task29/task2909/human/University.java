package com.javarush.task.task29.task2909.human;

import java.util.ArrayList;
import java.util.List;

public class University{

    private String name;
    private int age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    private List<Student> students = new ArrayList<>();

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    public University(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public Student getStudentWithAverageGrade(double averageGrade) {
        //TODO:
        for (Student student : students){
            if (student.getAverageGrade()==averageGrade) return student;
        }
        return null;
    }

    public Student getStudentWithMaxAverageGrade() {
        //TODO:
        Student studentWithMaxAverageGrade = students.get(0);
        double maxAverageGrade = students.get(0).getAverageGrade();
        for (Student student : students){
            if (student.getAverageGrade()>maxAverageGrade){
                studentWithMaxAverageGrade = student;
                maxAverageGrade = student.getAverageGrade();
            }
        }

        return studentWithMaxAverageGrade;
    }

    public Student getStudentWithMinAverageGrade() {
        //TODO:
        Student studentWithMinAverageGrade = students.get(0);
        double minAverageGrade = students.get(0).getAverageGrade();
        for (Student student : students){
            if (student.getAverageGrade() < minAverageGrade){
                studentWithMinAverageGrade = student;
                minAverageGrade = student.getAverageGrade();
            }
        }

        return studentWithMinAverageGrade;
    }

    public void expel(Student student){
        //student = getStudentWithMinAverageGrade();
        students.remove(student);
    }
}