package com.javarush.task.task22.task2208;

import java.util.Map;

/* 
Формируем WHERE
*/
public class Solution {
    public static void main(String[] args) {

    }
    public static String getQuery(Map<String, String> params) {
        StringBuilder sbout = new StringBuilder();
        String sout;
        int i=0;
        for (Map.Entry<String,String> entry : params.entrySet()){
            //i++;
            if (entry.getValue()!=null){
                i++;
                if (i>1) sbout.append(" and ");
                sbout.append(entry.getKey()).append(" = \'").append(entry.getValue()).append("\'");
            }
        }
        sout = sbout.toString();
        return sout;
    }
}
