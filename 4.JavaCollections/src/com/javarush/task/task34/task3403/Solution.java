package com.javarush.task.task34.task3403;

/* 
Разложение на множители с помощью рекурсии
*/
public class Solution {
    public void recursion(int n) {
        int k = 2;
        /*
        if (k>n/2) {
            System.out.println(n + " ");
            return;
        }
        if (n % k == 0){
            System.out.println(k);
            recursion(n/k);
        }else recursion(n);
        */
        while(k<=n){
            if (n%k==0){
                if (k!=n){
                    System.out.println(k + " ");
                    recursion(n/k);
                }else {
                    System.out.println(k);
                }
                return;
            }
            k++;
        }
    }
}
