package com.javarush.task.task20.task2003;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

/* 
Знакомство с properties
*/
public class Solution {
    public static Map<String, String> properties = new HashMap<>();

    public void fillInPropertiesMap() throws Exception {
        //implement this method - реализуйте этот метод
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String filename = reader.readLine();
        reader.close();
        InputStream inputStream = new FileInputStream(filename);
        load(inputStream);
        inputStream.close();
    }

    public void save(OutputStream outputStream) throws Exception {
        //implement this method - реализуйте этот метод
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(outputStream));
        //
        for (Map.Entry<String,String> entry : properties.entrySet()){
            bw.write(entry.getKey()+"="+entry.getValue());
        }
        bw.close();
    }

    public void load(InputStream inputStream) throws Exception {
        //implement this method - реализуйте этот метод
        BufferedReader br = new BufferedReader(new InputStreamReader(inputStream));
        //
        String line;
        while ((line=br.readLine())!=null){
            String[] words = line.split("=");
            properties.put(words[0],words[1]);
        }
        br.close();
    }

    public static void main(String[] args) {

    }
}
