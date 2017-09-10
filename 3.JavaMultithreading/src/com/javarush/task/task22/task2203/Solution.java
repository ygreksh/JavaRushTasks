package com.javarush.task.task22.task2203;

/* 
Между табуляциями
*/
public class Solution {
    public static String getPartOfString(String string) throws TooShortStringException {
        if (string==null) throw new TooShortStringException();
        if (!string.contains("\t")) throw new TooShortStringException();
        int countoftabs=0;
        char[] chars = string.toCharArray();
        int firsttab = string.indexOf("\t");
        int secondtab=0;
        for (int i=0;i<chars.length;i++){
            if (chars[i]=='\t')countoftabs++;
            if (countoftabs==2){secondtab=i;break;}
        }
        if (countoftabs<2) throw new TooShortStringException();
        String sub=string.substring(firsttab+1,secondtab);
        return sub;
    }

    public static class TooShortStringException extends Exception {
    }

    public static void main(String[] args) throws TooShortStringException {
        System.out.println(getPartOfString("\tJavaRush - лучший сервис \tобучения Java\t."));
    }
}
