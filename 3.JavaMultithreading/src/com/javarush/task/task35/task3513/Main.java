package com.javarush.task.task35.task3513;

import javax.swing.*;

public class Main {
    /*
    private static Model model;
    private static Controller controller;
    private static JFrame game;

    public Main() {
        model = new Model();
        controller = new Controller(model);
        game = new JFrame();
    }*/

    public static void main(String[] args){
        Model model = new Model();
        Controller controller = new Controller(model);
        JFrame game;
        game = new JFrame();
        game.setTitle("2048");
        game.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        game.setSize(450, 500);
        game.setResizable(false);

        game.add(controller.getView());


        game.setLocationRelativeTo(null);
        game.setVisible(true);
    }
}
