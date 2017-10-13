package com.javarush.task.task31.task3105;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

/* 
Добавление файла в архив
*/
public class Solution {
    public static void main(String[] args) throws IOException {
        String fileName = args[0];
        String zipPath = args[1];
        FileInputStream zipfile = new FileInputStream(zipPath);
        ZipInputStream zipInputStream = new ZipInputStream(zipfile);
        while (zipInputStream.available() > 0){
            ZipEntry zipEntry = zipInputStream.getNextEntry();

        }
    }
}
