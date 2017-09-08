package com.javarush.task.task20.task2026;

/* 
Алгоритмы-прямоугольники
*/
public class Solution {
    public static void main(String[] args) {
        byte[][] a = new byte[][]{
                {1, 1, 0, 0},
                {1, 1, 0, 0},
                {1, 1, 0, 0},
                {1, 1, 0, 1}
        };
        int count = getRectangleCount(a);
        System.out.println("count = " + count + ". Должно быть 2");
    }

    public static int getRectangleCount(byte[][] a) {
        int N = (int) Math.sqrt(a.length);
        int rectcount = 0;
        //поиск левого верхнего угла первого прямоугольника
        for (int j=0;j<N; j++){
            for (int i=0;i<N;i++) {
                if (a[i][j] == 1) {
                    //нашли лев-верх угол, ищем прав-верх угол
                    i--;
                    for (int k = j-1; k < N; k++) {
                        if (a[i][k]==0){
                            //нашли правиый верхний, спускаемся вниз
                            k--;
                            for (int l=i-1;l<N;l++){
                                //нашли правый нижний
                                if (a[l][k]==0){
                                    //добавили координаты углов в список
                                }
                            }
                        }
                    }
                }
            }
        }
        return 0;
    }
}
