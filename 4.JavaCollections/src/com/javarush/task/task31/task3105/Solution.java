package com.javarush.task.task31.task3105;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import java.util.zip.ZipOutputStream;

/* 
Добавление файла в архив
*/
public class Solution {
    public static void main(String[] args) throws IOException {
        String fileName = args[0];
        String zipPath = args[1];
        FileInputStream zipInputFile = new FileInputStream(zipPath);
        ZipInputStream zipInputStream = new ZipInputStream(zipInputFile);
        while (zipInputStream.available() > 0){
            ZipEntry zipEntry = zipInputStream.getNextEntry();

        }
        FileOutputStream zipOutFile = new FileOutputStream(zipPath);
        ZipOutputStream zipOutputStream = new ZipOutputStream(zipOutFile);
        zipOutputStream.putNextEntry(new ZipEntry(fileName));
        File file = new File(fileName);

        zipInputStream.close();
        zipOutputStream.close();
    }
}
