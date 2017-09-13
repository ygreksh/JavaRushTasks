package com.javarush.task.task23.task2312;

public class SnakeSection {
    private int x;
    private int y;


    public SnakeSection(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof SnakeSection)) return false;

        SnakeSection section = (SnakeSection) o;

        if (getX() != section.getX()) return false;
        return getY() == section.getY();
    }

    @Override
    public int hashCode() {
        int result = getX();
        result = 31 * result + getY();
        return result;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }


}
