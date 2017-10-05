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
        //Перевожу в числа разных систем исчисления и проверяю на палиндром

            for (int i=2;i<=36;i++){
                try {
                    String num = String.valueOf(Integer.parseInt(number,i));
                    StringBuilder sb = new StringBuilder(num);
                    String mun = sb.reverse().toString();
                    if (num.equals(mun)) {
                        set.add(i);
                        System.out.print(num + ". ");
                    }
                } catch (NumberFormatException e) {
                    //e.printStackTrace();
                }
            }

        return set;
    }
}