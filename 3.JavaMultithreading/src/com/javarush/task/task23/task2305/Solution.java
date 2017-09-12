package com.javarush.task.task23.task2305;

/* 
Inner
*/
public class Solution {
    public InnerClass[] innerClasses = new InnerClass[2];

    static public class InnerClass {
    }

    public static Solution[] getTwoSolutions() {
        Solution[] twoSol = new Solution[2];
        twoSol[0] = new Solution();
        twoSol[1] = new Solution();
        twoSol[0].innerClasses[0] = new InnerClass();
        twoSol[0].innerClasses[1] = new InnerClass();
        twoSol[1].innerClasses[0] = new InnerClass();
        twoSol[1].innerClasses[1] = new InnerClass();
        return twoSol;
    }

    public static void main(String[] args) {

    }
}
