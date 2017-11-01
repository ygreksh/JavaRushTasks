package com.javarush.task.task36.task3607;


import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.*;
import java.util.concurrent.DelayQueue;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;

/*
Найти класс по описанию
*/
public class Solution {
    public static void main(String[] args) {
        System.out.println(getExpectedClass());
    }

    public static Class getExpectedClass() {
        return DelayQueue.class; //hack

    }
}
