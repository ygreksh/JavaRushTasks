package com.javarush.task.task22.task2202;

/* 
Найти подстроку
*/
public class Solution {
    public static void main(String[] args) throws TooShortStringException {
        System.out.println(getPartOfString("JavaRush - лучший сервис обучения Java."));
    }

    public static String getPartOfString(String string) throws TooShortStringException {
        if (string==null) throw new TooShortStringException();
        int countofspaces = 0;
        int firstspace=0, lastspace=0;
        firstspace = string.indexOf(" ")+1;
        char[] chars = string.toCharArray();
        for (int i=0;i<chars.length;i++){
            if (chars[i]==' ')countofspaces++;
            //if (countofspaces==1)firstspace=i;
            if (countofspaces==4)lastspace=string.length();
            if (countofspaces==5){lastspace=i;break;}
        }
        if (countofspaces<4){throw new TooShortStringException();}
        String sub;
        //if (countofspaces>=5)
            sub = string.substring(firstspace,lastspace);
        //else sub = string.substring(firstspace);
        return sub;
    }

    public static class TooShortStringException extends RuntimeException {
    }
}
