package com.javarush.task.task07.task0701;

import java.io.*;

/* 
Массивный максимум
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        int[] array = initializeArray();
        int max = max(array);
        System.out.println(max);
    }

    public static int[] initializeArray() throws IOException {
        InputStream is = System.in;
        Reader isr = new InputStreamReader(is);
        BufferedReader br = new BufferedReader(isr);
        int[] array= new int[20];
        String s=null;
        for (int i=0; i<20; i++){
            s = br.readLine();
            array[i] = Integer.parseInt(s);
        }

        return array;
    }

    public static int max(int[] array) {
        // найди максимальное значение
        int max=array[0];
        for(int i=0;i<20;i++){
            if (array[i]>max) max=array[i];
        }
        return max;
    }
}
