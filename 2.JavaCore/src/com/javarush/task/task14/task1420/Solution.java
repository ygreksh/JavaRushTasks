package com.javarush.task.task14.task1420;

/* 
НОД
*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int a = 0;
        int b = 0;

        try {
            if((a = Integer.parseInt(br.readLine()))<0){a=-a;}
            if((b = Integer.parseInt(br.readLine()))<0){b=-b;}
        } catch (NumberFormatException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


        int max = a;
        if (b>a) max = b;
        int nod = 0;
        for (int i=max-1; i>0; i--){
            if (a%i==0 && b%i==0) {
                nod = i;
                break;
            }
        }
        System.out.println(nod);
    }
}
