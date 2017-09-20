package com.javarush.task.task29.task2909.human;

import java.util.ArrayList;
import java.util.List;

public class University {
    private List<Student> students = new ArrayList<>();
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

    public University(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    public Student getStudentWithAverageGrade(double avrgrade) {
        //TODO:
        for (Student student : students){

            if (student.getAverageGrade()==avrgrade) {
                return student;
            }
        }
        return null;
    }

    public Student getStudentWithMaxAverageGrade() {
        //TODO:
        double maxavrgrade=students.get(0).getAverageGrade();
        Student maxavrStudent=students.get(0);
        for (Student student : students){

            if (student.getAverageGrade()>maxavrgrade) {
                maxavrgrade = student.getAverageGrade();
                maxavrStudent = student;
            }
        }
        return maxavrStudent;
    }
/*
    public void getStudentWithMinAverageGradeAndExpel() {
        //TODO:
        expel(getStudentWithMinAverageGrade());
    }
*/
    public Student getStudentWithMinAverageGrade(){
        double minavrgrade=students.get(0).getAverageGrade();
        Student minavrStudent=students.get(0);
        for (Student student : students){

            if (student.getAverageGrade()<minavrgrade) {
                minavrgrade = student.getAverageGrade();
                minavrStudent = student;
            }
        }
        return minavrStudent;
    }
    public void expel(Student student){
        //student = getStudentWithMinAverageGrade();
        students.remove(student);
    }
}