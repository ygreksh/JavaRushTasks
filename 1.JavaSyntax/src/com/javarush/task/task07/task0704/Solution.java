package com.javarush.task.task07.task0704;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.Reader;

/* 
Переверни массив
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        Reader r = new InputStreamReader(System.in);
        BufferedReader reader = new BufferedReader(r);

//ввод строк с клавиатуры
        int[] list = new int[10];
        for (int i = 0; i < 10; i++)
        {
            String s = reader.readLine();
            list[i] = Integer.parseInt(s);
        }
//переворот
        int temp;
        for(int i=0;i<5; i++){
            temp = list[i];
            list[i] = list[9-i];
            list[9-i] = temp;
        }

//вывод содержимого массива на экран
        for (int i = 0; i < 10; i++)
        {
            System.out.println(list[i]);
        }
    }
}

