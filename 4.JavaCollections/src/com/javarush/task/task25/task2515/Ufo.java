package com.javarush.task.task25.task2515;

public class Ufo extends BaseObject {
    private static int[][] matrix = {
            {0, 0, 0, 0, 0},
            {0, 0, 1, 0, 0},
            {0, 0, 1, 0, 0},
            {1, 0, 1, 0, 1},
            {1, 1, 1, 1, 1},
    };
    public Ufo(double x, double y) {
        super(x, y, 3);
    }

    @Override
    public void move() {
        int height = Space.game.getHeight();
        double dx = Math.random() * 2 - 1; //-1..1
        double dy = Math.random() * 2 - 1; //-1..1
        x += dx;
        y += dy;
        //if (y <= height/2) y = height/2+1;
        checkBorders(radius, Space.game.getWidth() - radius + 1, 1, Space.game.getHeight() / 2);
        int random10 = (int) (Math.random() * 10);
        if (random10 == 1)
            fire();
    }

    @Override
    public void draw(Canvas canvas) {
        canvas.drawMatrix(x - radius + 1, y - radius + 1, matrix, 'U');
    }
    public void fire(){
        Bomb bomb = new Bomb(x,y+3);
        Space.game.getBombs().add(bomb);
    }
}
