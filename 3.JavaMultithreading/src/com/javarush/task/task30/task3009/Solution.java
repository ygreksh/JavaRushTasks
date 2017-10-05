package com.javarush.task.task30.task3009;

import java.util.HashSet;
import java.util.Set;

/* 
Палиндром?
*/

public class Solution {
    public static void main(String[] args) {
        System.out.println(getRadix("112"));        //expected output: [3, 27, 13, 15]
        System.out.println(getRadix("123"));        //expected output: [6]
        System.out.println(getRadix("5321"));       //expected output: []
        System.out.println(getRadix("1A"));         //expected output: []
    }
    private static Set<Integer> getRadix(String number){
        Set<Integer> set = new HashSet<>();
        String chars = "ABCDEFGHIGKLMNOPQRSTUVWXYZ";
        try {
            int num = Integer.parseInt(number);
            //int l = number.length();
            //System.out.println("Строка: " + number + ". Число в 10-й системе: " + num);
            for (int i=2;i<=36;i++){
                StringBuilder res = new StringBuilder();
                int n = num;
                while (n>i) {
                    int ost = n%i;
                    if (ost<10) {
                        res.append(String.valueOf(ost));
                    }else {
                        res.append(chars.substring(ost-10,ost-9));
                        //System.out.println("Добавили " + chars.substring(ost-10,ost-9) + " вместо " + ost);
                    }
                    n=n/i;
                }
                if (n<10) {
                    res.append(String.valueOf(n));
                }else {
                    res.append(chars.substring(n-10,n-9));
                    //System.out.println("Добавили " + chars.substring(n-10,n-9) + " вместо " + n);
                }
                //System.out.println(number + " Число в " + i + "-й системе: " + res.reverse().toString() + ". Реверс: " + res.toString());
                if (res.toString().equals(res.reverse().toString())){
                    set.add(i);
                    //System.out.println(number + " Число в " + i + "-й системе: " + res.reverse().toString() + ". Реверс: " + res.toString());
                }
            }
        } catch (NumberFormatException e) {
            //e.printStackTrace();
        }

        return set;
    }
}