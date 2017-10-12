package com.javarush.task.task31.task3102;

import java.io.File;
import java.io.IOException;
import java.util.*;

/* 
Находим все файлы
*/
public class Solution {
    public static List<String> getFileTree(String root) throws IOException {
        List<String> result = new ArrayList<>();
        File rootFile = new File(root);
        File[] files = rootFile.listFiles();
        Queue<File> queue = new PriorityQueue<>();
        Collections.addAll(queue,files);

        //Collections.sort(queue);
        while (!queue.isEmpty()){
            File f = queue.remove();
            if (f.isDirectory()) {
                Collections.addAll(queue, f.listFiles());
                continue;
            }else result.add(f.getAbsolutePath());
        }
        return result;

    }

    public static void main(String[] args) {
        
    }
}
