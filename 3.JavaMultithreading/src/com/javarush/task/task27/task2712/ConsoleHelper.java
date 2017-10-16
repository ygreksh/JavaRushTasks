package com.javarush.task.task27.task2712;

import com.javarush.task.task27.task2712.kitchen.Dish;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class ConsoleHelper {
    static BufferedReader reader;
    public static void writeMessage(String message){
        System.out.println(message);
    }
    public static String readString() throws IOException {
        reader = new BufferedReader(new InputStreamReader(System.in));
        return reader.readLine();
    }
    public static List<Dish> getAllDishesForOrder() throws IOException {
        List<Dish> dishes = new ArrayList<>();
        writeMessage("Выберите блюдо или exit для завершения заказа.");
        writeMessage(Dish.allDishesToString());
        while(true) {
            String choise = readString();
            if (choise.equals("exit")) break;
            Dish d;
            if (choise.equals(Dish.Fish.toString())) dishes.add(Dish.Fish);
            if (choise.equals(Dish.Juice.toString())) dishes.add(Dish.Juice);
            if (choise.equals(Dish.Soup.toString())) dishes.add(Dish.Soup);
            if (choise.equals(Dish.Steak.toString())) dishes.add(Dish.Steak);
            if (choise.equals(Dish.Water.toString())) dishes.add(Dish.Water);
        }
        return dishes;
    }
}
