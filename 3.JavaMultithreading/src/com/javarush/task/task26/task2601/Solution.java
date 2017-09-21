package com.javarush.task.task26.task2601;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;

/*
Почитать в инете про медиану выборки
*/
public class Solution {

    public static void main(String[] args) {
        Integer[] array = new Integer[]{13, 8, 15, 5, 17};
        /*
        System.out.println("Source array:");
        for (Integer i : array){
            System.out.print(i + ", ");
        }*/
        Integer[] sortedArray = sort(array);
        /*
        System.out.println("Sorted array:");
        for (Integer i : sortedArray){
            System.out.print(i + ", ");
        }*/
    }

    public static Integer[] sort(Integer[] array) {
        //implement logic here
        ArrayList<Integer> arrayList = new ArrayList<>();
        for (int i=0; i<array.length;i++){
            arrayList.add(array[i]);
        }
        Collections.sort(arrayList);
        int indexOneOfMediana;
        int indexTwoOfMediana;
        int mediana;
        if (arrayList.size()%2!=0){
            indexOneOfMediana=arrayList.size()/2;
            mediana = arrayList.get(indexOneOfMediana);
        }
        else {
            indexOneOfMediana = arrayList.size()/2-1;
            indexTwoOfMediana = arrayList.size()/2;
            mediana = (arrayList.get(indexOneOfMediana)+arrayList.get(indexTwoOfMediana))/2;
        }
        //System.out.println("Mediana: " + mediana);
        Comparator<Integer> comparatorByMediana = new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                double value = Math.abs(o1-mediana) - Math.abs(o2-mediana);
                if (value == 0)
                    value = o1 - o2;
                return (int)value;
            }
        };
        Collections.sort(arrayList,comparatorByMediana);

        return arrayList.toArray(array);
    }
}
