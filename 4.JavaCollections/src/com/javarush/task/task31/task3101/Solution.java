package com.javarush.task.task31.task3101;

import java.io.File;

/*
Проход по дереву файлов
*/
public class Solution {
    public static void main(String[] args) {
        String path = args[0];
        String resultFileAbsolutePath = args[1];
        File dir = new File(path);
        File[] files = dir.listFiles();
        for (File file : files){

        }
    }
}
