package com.javarush.task.task28.task2810;

import com.javarush.task.task28.task2810.model.HHStrategy;
import com.javarush.task.task28.task2810.model.Provider;

public class Aggregator {
    public static void main(String[] args) throws NullPointerException{

        Provider provider = new Provider(new HHStrategy());
        Controller controller = new Controller(provider);
        try {
            controller.scan();
        } catch (NullPointerException e) {

        }
    }
}
