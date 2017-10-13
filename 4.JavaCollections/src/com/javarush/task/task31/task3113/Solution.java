package com.javarush.task.task31.task3113;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Queue;

/* 
Что внутри папки?
*/
public class Solution {
    static int countFiles=0;
    static int countDir=0;
    static long dirSize =0;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String filePath = reader.readLine();
        reader.close();
        Path path = Paths.get(filePath);
        if (!Files.isDirectory(path.toAbsolutePath())) {
            System.out.println(path.toAbsolutePath() + " - не папка");
            return;
        } else {
            Files.walkFileTree(path, new myFileVisitor());
            System.out.println("Всего папок - " + (countDir - 1));
            System.out.println("Всего файлов - " + countFiles);
            System.out.println("Общий размер - " + dirSize);
        }
        /*BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String line = reader.readLine();
        Path directory = Paths.get(line);
        int countDirectories = 0;
        int countAllFilesAndDirectories = 0;
        int countSize = 0;
        if (!Files.isDirectory(directory)){
            System.out.println(directory.toString() + " - не папка");
        }else {

            File rootFile = directory.toFile();
            File[] files = rootFile.listFiles();
            Queue<File> queue = new PriorityQueue<>();
            Collections.addAll(queue, files);
            while (!queue.isEmpty()) {
                File f = queue.remove();
                if (f.isDirectory()) {
                    Collections.addAll(queue, f.listFiles());
                    countDirectories++;
                    //countAllFilesAndDirectories++;
                } else {
                    countAllFilesAndDirectories++;
                    countSize += Files.size(Paths.get(f.toString()));
                }
            }

            System.out.println("Всего папок - " + countDirectories);
            System.out.println("Всего файлов - " + countAllFilesAndDirectories);
            System.out.println("Общий размер - " + countSize);
        }*/

        /*
        List<String> result = new ArrayList<>();
        File rootFile = new File(root);
        File[] files = rootFile.listFiles();
        Queue<File> queue = new PriorityQueue<>();
        Collections.addAll(queue,files);

        while (!queue.isEmpty()){
            File f = queue.remove();
            if (f.isDirectory()) {
                Collections.addAll(queue, f.listFiles());
                continue;
            }else result.add(f.getAbsolutePath());
        }
         */


    }
    static class myFileVisitor extends SimpleFileVisitor<Path>
    {
        @Override
        public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs) throws IOException {
            if(Files.isDirectory(dir)){ countDir++;}
            return FileVisitResult.CONTINUE;
        }
        @Override
        public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
            if(!Files.isDirectory(file)){countFiles++;dirSize += Files.size(file);}
            return FileVisitResult.CONTINUE;
        }
    }
}
