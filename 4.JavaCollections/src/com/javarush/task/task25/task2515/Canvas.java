package com.javarush.task.task25.task2515;

public class Canvas {
    private int width;
    private int height;
    private char[][] matrix;

    public Canvas(int width, int height) {
        this.width = width;
        this.height = height;
        matrix = new char[height+2][width+2];
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public char[][] getMatrix() {
        return matrix;
    }
    public void setPoint(double x, double y, char c){
        int intX = (int) Math.round(x);
        int intY = (int) Math.round(y);
        if (intX < 0 || intY < 0 || intX > matrix[0].length || intY > matrix.length) return;
        else matrix[intY][intX] = c;
    }
    public void drawMatrix(double x, double y, int[][] matrix, char c){
        /*
        //int intX = (int)Math.round(x);
        //int intY = (int)Math.round(y);
        for (int i=0; i<matrix.length; i++){
            for (int j=0; j<matrix[0].length; j++){
                if (matrix[i][j]==1) {
                    //this.matrix[j+intX][i+intY] = (char) matrix[j][i];
                    setPoint(j+x,i+y,c);
                }
            }
        }
        */
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] != 0) {
                    setPoint(x + j, y + i, c);
                }
            }
        }
    }
}
