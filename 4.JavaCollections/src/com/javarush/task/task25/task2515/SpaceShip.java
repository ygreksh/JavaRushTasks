package com.javarush.task.task25.task2515;

public class SpaceShip extends BaseObject {
    private double dx = 0;
    public SpaceShip(double x, double y) {
        super(x, y, 3);
    }
    public void moveLeft(){
        dx = -1;
    }
    public void moveRight(){
        dx = 1;
    }

    @Override
    public void move() {
        x += dx;
        checkBorders(x-radius,x+radius,y-radius, y+radius);
    }

    @Override
    public void draw(Canvas canvas) {
        super.draw(canvas);
    }
    public void fire(){
        Rocket leftRocket = new Rocket(x-2, y);
        Rocket rightRocket = new Rocket(x+2, y);
        Space.game.getRockets().add(leftRocket);
        Space.game.getRockets().add(rightRocket);
    }
}
