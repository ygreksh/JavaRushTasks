package com.javarush.task.task34.task3410.model;

import java.nio.file.Path;
import java.util.HashSet;
import java.util.Set;

public class LevelLoader {
    private Path levels;
    public LevelLoader(Path levels) {
        this.levels = levels;
    }
    public GameObjects getLevel(int level){
        int x0 = Model.FIELD_CELL_SIZE / 2;
        int y0 = Model.FIELD_CELL_SIZE / 2;
        Player player = new Player(x0, y0);
        Set<Home> homes = new HashSet<>();
        homes.add(new Home(x0 + Model.FIELD_CELL_SIZE, y0));
        Set<Box> boxes = new HashSet<>();
        boxes.add(new Box(x0, y0 + Model.FIELD_CELL_SIZE));
        Set<Wall> walls = new HashSet<>();
        walls.add(new Wall(x0 + Model.FIELD_CELL_SIZE, y0 + Model.FIELD_CELL_SIZE));
        walls.add(new Wall(x0, y0 + Model.FIELD_CELL_SIZE * 2));
        return new GameObjects(walls, boxes, homes, player);
    }
}
