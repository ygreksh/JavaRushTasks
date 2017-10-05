package com.javarush.task.task29.task2907;

import java.math.BigDecimal;

/* 
Этот странный BigDecimal
*/
public class Solution {
    public static void main(String[] args) {
        System.out.println(getValue(1.1d, 1.2d));
    }

    public static BigDecimal getValue(double v1, double v2) {
        BigDecimal b1 = new BigDecimal(BigDecimal.valueOf(v1).doubleValue());
        b1 = BigDecimal.valueOf(v1);
        BigDecimal b2 = new BigDecimal(BigDecimal.valueOf(v2).doubleValue());
        b2 = BigDecimal.valueOf(v2);
        //b1  = b1.add(b2);
        return b1.add(b2);
    }
}