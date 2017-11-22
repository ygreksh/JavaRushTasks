package com.javarush.task.task34.task3410.view;

import com.javarush.task.task34.task3410.controller.EventListener;
import com.javarush.task.task34.task3410.model.Box;
import com.javarush.task.task34.task3410.model.GameObject;
import com.javarush.task.task34.task3410.model.GameObjects;
import com.javarush.task.task34.task3410.model.Player;

import javax.swing.*;
import java.awt.*;

public class Field extends JPanel {
    private View view;
    private EventListener eventListener;

    public Field(View view) {
        this.view = view;
    }
    public void paint(Graphics g){
        /*
        Box box = new Box(100,100);
        box.draw(g);

        Player player = new Player(200, 100);
        player.draw(g);
        */
        g.setColor(Color.BLACK);
        g.fillRect(0,0,500,500);
        GameObjects gameObjects = view.getGameObjects();
        for (GameObject gameObject : gameObjects.getAll()){
            gameObject.draw(g);
        }
    }
    public void setEventListener(EventListener eventListener){
        this.eventListener = eventListener;
    }
}
