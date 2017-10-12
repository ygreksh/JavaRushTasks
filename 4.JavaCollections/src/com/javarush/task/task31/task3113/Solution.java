package com.javarush.task.task31.task3113;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/* 
Что внутри папки?
*/
public class Solution {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String line = reader.readLine();
        Path directory = Paths.get(line);
        if (!Files.isDirectory(directory)){
            System.out.println(directory.toString() + " - не папка");
        }
        int countDirectories = 0;
        int countAllFilesAndDirectories = 0;
        int countSize = 0;

    }
}
