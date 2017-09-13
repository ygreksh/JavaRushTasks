package com.javarush.task.task23.task2312;

import java.util.ArrayList;
import java.util.List;

public class Snake {
    private List<SnakeSection> sections;
    private boolean isAlive;
    private SnakeDirection direction;

    public List<SnakeSection> getSections() {
        return sections;
    }

    public boolean isAlive() {
        return isAlive;
    }

    public SnakeDirection getDirection() {
        return direction;
    }

    public void setDirection(SnakeDirection direction) {
        this.direction = direction;
    }
    public Snake(int x, int y){
        sections = new ArrayList<>();
        sections.add(new SnakeSection(x,y));
        isAlive = true;
    }
    public int getX(){ return sections.get(0).getX();}
    public int getY(){ return sections.get(0).getY();}

    public void move(){
        if (!isAlive) return;

        if (direction == SnakeDirection.UP)
            move(0, -1);
        else if (direction == SnakeDirection.RIGHT)
            move(1, 0);
        else if (direction == SnakeDirection.DOWN)
            move(0, 1);
        else if (direction == SnakeDirection.LEFT)
            move(-1, 0);
    }
    public void move(int x, int y){
        SnakeSection head = sections.get(0);
        head = new SnakeSection(head.getX() + x, head.getY() + y);
        checkBody(head);
        checkBorders(head);
        if (isAlive()) {
            if (Room.game.getMouse().getX() == head.getX() && Room.game.getMouse().getY() == head.getY()) {
                Room.game.eatMouse();
                sections.add(0, head);
            } else {
                sections.add(0, head);
                sections.remove(sections.size()-1);
            }
        }
    }

    public void checkBorders(SnakeSection head){
        if (head.getX()<0 || head.getX()>=Room.game.getWidth() ||
                head.getY()<0 || head.getY()>=Room.game.getHeight()){
            isAlive=false;
        }
    }
    public void checkBody(SnakeSection head){
        if (sections.contains(head)) isAlive=false;
        /*for (SnakeSection s : Room.game.getSnake().getSections()){
            if (head.getX()==s.getX() && head.getY()==s.getY()) isAlive=false;
        }*/
    }
}
