package com.javarush.task.task35.task3513;

import java.util.ArrayList;
import java.util.List;

public class Model {
    private static final int FIELD_WIDTH = 4;
    private Tile[][] gameTiles;
    public int score = 0;
    public int maxTile = 2;

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
    private boolean compressTiles(Tile[] tiles){
        boolean flag = false;
        for (int i=0;i<tiles.length-1;i++){
            if (tiles[i].value==0 && tiles[i+1].value!=0){
                Tile temp = tiles[i];
                tiles[i] = tiles[i+1];
                tiles[i+1] = temp;
                i=-1;
                flag = true;
            }
        }
        return flag;
    }
    private boolean mergeTiles(Tile[] tiles){
        boolean flag = false;
        for (int i=0;i<tiles.length-1;i++){
            if (tiles[i].value!=0 && tiles[i].value==tiles[i+1].value){
                Tile temp = new Tile(tiles[i].value * 2);
                if (maxTile < temp.value) {
                    maxTile = temp.value;
                }
                score += maxTile;
                tiles[i] = temp;
                tiles[i+1].value = 0;
                compressTiles(tiles);
                flag = true;
            }
        }
        return flag;
    }
    public void left(){
        boolean flag1 = false;
        boolean flag2 = false;
        boolean isChanged = false;
        for (int i=0; i<FIELD_WIDTH;i++){
            flag1 = compressTiles(gameTiles[i]);
            flag2 = mergeTiles(gameTiles[i]);
            if (flag1 | flag2) isChanged = true;
        }
        if (isChanged) addTile();
    }
    public void rotate() {
        for (int k = 0; k < FIELD_WIDTH/2; k++) {
            for (int j = k; j < FIELD_WIDTH-k-1; j++) {
                Tile tmp = gameTiles[k][j];
                gameTiles[k][j] = gameTiles[j][3 - k];
                gameTiles[j][3 - k] = gameTiles[3 - k][3 - j];
                gameTiles[3 - k][3 - j] = gameTiles[3 - j][k];
                gameTiles[3 - j][k] = tmp;
            }
        }
    }
    public void right() {
        rotate();
        rotate();
        left();
        rotate();
        rotate();
    }

    public void up() {
        rotate();
        left();
        rotate();
        rotate();
        rotate();
    }

    public void down() {
        rotate();
        rotate();
        rotate();
        left();
        rotate();
    }
}

