package com.javarush.task.task15.task1527;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/* 
Парсер реквестов
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        //add your code here
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String s = reader.readLine();
        //String[] sss = s.split("?",2);
        String substr1 = s.substring(s.indexOf("?")+1);  //выбрали строку от знака вопроса до конца
        String[] arraystring1 = substr1.split("&");  //разбили на подстроки разделенные символом амперсант
        ArrayList<String > arraystring2 = new ArrayList<>();
        int flag = 0;
        for (int i=0; i<arraystring1.length;i++){
            String[] sss = arraystring1[i].split("=+");
            System.out.print(sss[0]+" ");
            if (sss[0].equals("obj")){
                flag++;
                arraystring2.add(sss[1]);
            }
        }
        if(flag>0) {
            System.out.println("");
            for (int i = 0; i < arraystring2.size(); i++) {
                try {
                    if (arraystring2.get(i).contains(".")) {
                        alert(Double.parseDouble(arraystring2.get(i)));
                    } else alert(arraystring2.get(i));
                }catch (NumberFormatException e){alert(arraystring2.get(i));}
            }
        }
    }

    public static void alert(double value) {
        System.out.println("double " + value);
    }

    public static void alert(String value) {
        System.out.println("String " + value);
    }
}
