package com.javarush.task.task29.task2909.human;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Human implements Alive{
    private static int nextId = 0;
    private int id;
    protected int age;
    protected String name;
    private List<Human> children = new ArrayList<>();

    public List<Human> getChildren() {
        return Collections.unmodifiableList(children);
    }

    public void addChild(Human child){
        children.add(child);
    }
    public void removeChild(Human child){
        children.remove(child);
    }

    //protected int[] size;
    public class Size{
        public int height;
        public int weight;
    }
    public Size size;

    private BloodGroup bloodGroup;

    public void setBloodGroup(BloodGroup bloodGroup) {
        this.bloodGroup = bloodGroup;
    }

    public BloodGroup getBloodGroup() {
        return bloodGroup;
    }

    public Human(String name, int age) {
        this.id = nextId;
        nextId++;
        this.name = name;
        this.age = age;
    }
    public String getPosition(){return "Человек";}
    public int getAge() {
        return age;
    }

    public String getName() {
        return name;
    }

    public void live(){}

    public int getId() {
        return id;
    }

    public void printSize() {
        System.out.println("Рост: " + size.height + " Вес: " + size.weight);
    }

    public void printData(){
        System.out.println(getPosition() + ": " + getName());
    }
}