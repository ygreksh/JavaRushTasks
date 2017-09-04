package com.javarush.task.task07.task0702;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;

/* 
Массив из строчек в обратном порядке
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        InputStream is = System.in;//напишите тут ваш код
        Reader isr = new InputStreamReader(is);
        BufferedReader br = new BufferedReader(isr);

        String[] array = new String[10];
        int i;
        for (i=0;i<8;i++){
            array[i] = br.readLine();
        }

        for(i=9;i>=0;i--){
            System.out.println(array[i]);
        }
    }
}