package com.javarush.task.task30.task3002;

/* 
Осваиваем методы класса Integer
*/
public class Solution {

    public static void main(String[] args) {
        System.out.println(convertToDecimalSystem("0x16")); //22
        System.out.println(convertToDecimalSystem("012"));  //10
        System.out.println(convertToDecimalSystem("0b10")); //2
        System.out.println(convertToDecimalSystem("62"));   //62
    }

    public static String convertToDecimalSystem(String s) {
        //напишите тут ваш код
        String result = null;
        if (s.startsWith("0x")){
            String s1 = s.replace("0x","");
            result = String.valueOf(Integer.parseInt(s1,16));
        }else if (s.startsWith("0b")){
            String s1 = s.replace("0b","");
            result = String.valueOf(Integer.parseInt(s1,2));
        }else if (s.startsWith("0")){
            result = String.valueOf(Integer.parseInt(s,8));
        }else result = s;
        return result;
    }
}
