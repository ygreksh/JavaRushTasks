package com.javarush.task.task34.task3410.view;

import com.javarush.task.task34.task3410.controller.EventListener;
import com.javarush.task.task34.task3410.model.*;
import com.javarush.task.task34.task3410.model.Box;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Field extends JPanel {
    private View view;
    private EventListener eventListener;

    public Field(View view) {
        this.view = view;
        KeyHandler keyHandler = new KeyHandler();
        this.addKeyListener(keyHandler);
        this.setFocusable(true);
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

    public class KeyHandler extends KeyAdapter{
        @Override
        public void keyPressed(KeyEvent keyEvent) {
            //super.keyPressed(keyEvent);
            switch (keyEvent.getKeyCode()){
                case KeyEvent.VK_UP: eventListener.move(Direction.UP); break;
                case KeyEvent.VK_DOWN: eventListener.move(Direction.DOWN); break;
                case KeyEvent.VK_LEFT: eventListener.move(Direction.LEFT); break;
                case KeyEvent.VK_RIGHT: eventListener.move(Direction.RIGHT); break;
                case KeyEvent.VK_R: eventListener.restart(); break;

            }
        }
    }
}
