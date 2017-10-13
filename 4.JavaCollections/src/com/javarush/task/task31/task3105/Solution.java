package com.javarush.task.task31.task3105;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import java.util.zip.ZipOutputStream;

/* 
Добавление файла в архив
*/
public class Solution {
    public static void main(String[] args) throws Exception {
        /*
        String fileName = args[0];
        String zipPath = args[1];
        FileInputStream zipInputFile = new FileInputStream(zipPath);
        ZipInputStream zipInputStream = new ZipInputStream(zipInputFile);
        while (zipInputStream.available() > 0){
            ZipEntry zipEntry = zipInputStream.getNextEntry();
            //
        }
        FileOutputStream zipOutFile = new FileOutputStream(zipPath);
        ZipOutputStream zipOutputStream = new ZipOutputStream(zipOutFile);
        zipOutputStream.putNextEntry(new ZipEntry(fileName));
        File file = new File(fileName);
        Files.copy(file.toPath(),zipOutputStream);

        zipInputStream.close();
        zipOutputStream.close();
        */
        boolean exist = false;
        String fileName = args[0];
        String zipName = args[1];
        FileInputStream fis = new FileInputStream(zipName);
        ZipInputStream zis = new ZipInputStream(new BufferedInputStream(fis));Map<ZipEntry, byte[]> map = new HashMap<>();

        String fileWithoutPathName = new File(fileName).getName();


        ZipEntry ze;
        while ((ze = zis.getNextEntry()) != null) {
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            byte[] buffer = new byte[1024];
            int count;
            while ((count = zis.read(buffer)) != -1) {
                baos.write(buffer, 0, count);
            }
            map.put(ze, baos.toByteArray());
        }
        zis.close();

        FileOutputStream fos = new FileOutputStream(zipName);
        ZipOutputStream zos = new ZipOutputStream(new BufferedOutputStream(fos));
        for (Map.Entry<ZipEntry, byte[]> pair : map.entrySet()) {
            if (fileWithoutPathName.equals(pair.getKey().getName())) {
                exist = true;
                continue;
            }
            zos.putNextEntry(pair.getKey());
            zos.write(pair.getValue());
            zos.closeEntry();
        }

        if (exist) {
            FileInputStream fis2 = new FileInputStream(fileName);
            byte[] fileBytes = new byte[fis2.available()];
            fis2.read(fileBytes);
            fis2.close();

            ZipEntry zipEntry = new ZipEntry("new/" + fileWithoutPathName);
            zos.putNextEntry(zipEntry);
            zos.write(fileBytes);
            zos.closeEntry();
            zos.close();
        }
        else {
            zos.closeEntry();
            zos.close();
        }
    }
}
