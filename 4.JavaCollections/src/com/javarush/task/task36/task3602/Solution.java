package com.javarush.task.task36.task3602;


import java.util.Collections;
import java.util.LinkedList;

/*
Найти класс по описанию
*/
public class Solution {
    public static void main(String[] args) throws ClassNotFoundException {
        System.out.println(getExpectedClass());
    }

    public static Class getExpectedClass() throws ClassNotFoundException {
        for (Class clazz : Collections.class.getDeclaredClasses()){}
        try {
            return Class.forName("java.util.Collections$EmptyList");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }
}
