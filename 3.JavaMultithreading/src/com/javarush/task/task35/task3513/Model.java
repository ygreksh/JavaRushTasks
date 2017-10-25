package com.javarush.task.task35.task3513;

import java.util.ArrayList;
import java.util.List;

public class Model {
    private static final int FIELD_WIDTH = 4;
    private Tile[][] gameTiles;

    public Model() {

        resetGameTiles();
    }
    public List<Tile> getEmptyTiles(){
        List<Tile> emptyTiles = new ArrayList<>();
        for (int i=0;i<FIELD_WIDTH;i++){
            for (int j=0;j<FIELD_WIDTH;j++){
                if (gameTiles[i][j].isEmpty()) {
                    emptyTiles.add(gameTiles[i][j]);
                }
            }
        }
        return emptyTiles;
    }
    public void addTile(){

        List<Tile> emptyTiles = getEmptyTiles();
        int countOfEmptyTiles = emptyTiles.size();
        int value;
        //if(Math.random() < 0.9) value=2;
        //else value=4;
        if (emptyTiles != null && countOfEmptyTiles != 0)
        emptyTiles.get((int) (Math.random()*countOfEmptyTiles)).value = (Math.random() < 0.9 ? 2 : 4);

        /*
        List<Tile> listForChanges = getEmptyTiles();
        if (listForChanges != null && listForChanges.size() != 0) {
            listForChanges.get((int) (listForChanges.size() * Math.random())).value =
                    (Math.random() < 0.9 ? 2 : 4);
        }
        */
    }
    public void resetGameTiles(){

        gameTiles = new Tile[FIELD_WIDTH][FIELD_WIDTH];
        for (int i=0;i<gameTiles.length;i++){
            for (int j=0;j<FIELD_WIDTH;j++){
                gameTiles[i][j] = new Tile();
            }
        }
        addTile();
        addTile();
    }
}

