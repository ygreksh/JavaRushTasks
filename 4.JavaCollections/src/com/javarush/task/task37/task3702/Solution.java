package com.javarush.task.task37.task3702;

import com.javarush.task.task37.task3702.male.MaleFactory;

public class Solution {
    public static void main(String[] args){
        MaleFactory factory = new MaleFactory();
        Human man1 = factory.getPerson(99);
        Human man2 = factory.getPerson(4);
        Human man3 = factory.getPerson(15);
        System.out.println(man1);
        System.out.println(man2);
        System.out.println(man3);
    }
}
