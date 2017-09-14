package com.javarush.task.task24.task2413;

public class Canvas {
    private int width;
    private int height;
    private char[][]matrix;

    public Canvas(int width, int height) {
        this.width = width;
        this.height = height;
        matrix = new char[height+2][width+2];
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public char[][] getMatrix() {
        return matrix;
    }

    public void setMatrix(char[][] matrix) {
        this.matrix = matrix;
    }

    public void setPoint(double x, double y, char c){
        int intX = (int) Math.round(x);
        int intY = (int) Math.round(y);
        /*
        if ((intX>=0 && intX<=matrix[0].length) && (intY>=0 && intY<=matrix.length )) {
            matrix[intX][intY] = c;
        }*/
        if (intX<0 || intY<0 || intX>matrix[0].length || intY>matrix.length) return;
        matrix[intY][intX] = c;
    }

    public void drawMatrix(double x, double y, int[][] matrix, char c){
        for (int i=0;i<matrix.length;i++){
            for (int j=0;j<matrix[0].length;j++){
                if(matrix[i][j]!=0) setPoint(x+j,y+i,c);
            }
        }

    }
}
