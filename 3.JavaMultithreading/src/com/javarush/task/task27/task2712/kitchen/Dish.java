package com.javarush.task.task27.task2712.kitchen;

import java.util.ArrayList;

public enum Dish {
    Fish, Steak, Soup, Juice, Water;
    public static String allDishesToString(){
        String dishes = "";
        for (Dish dish : Dish.values()){
            dishes += dish + ", ";
        }
        return (dishes.length() != 0) ? dishes.substring(0, dishes.lastIndexOf(",")) : "";
    }
}
