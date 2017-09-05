package com.javarush.task.task20.task2003;


import java.io.*;
import java.util.*;

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
        Properties prop = new Properties();
        //
        for (Map.Entry<String,String> entry : properties.entrySet()){
            prop.setProperty(entry.getKey(), entry.getValue());
        }
        prop.store(outputStream,null);
        //bw.close();
    }

    public void load(InputStream inputStream) throws Exception {
        //implement this method - реализуйте этот метод
        Properties prop = new Properties();
        prop.load(inputStream);
        Set<String> set;
        set = prop.stringPropertyNames();
        for (String s : set){
            properties.put(s, prop.getProperty(s));
        }
    }

    public static void main(String[] args) {

    }
}
