package com.Fborralho.hero;

public class Position {
    private int x;
    private int y;
    public Position(int x, int y){
        this.x = x;
        this.y = y;
    }

    public int getX(){
        return x;
    }
    public int getY(){
        return y;
    }

    public void setX(int x){
        this.x = x;
    }

    public void setY(int y){
        this.y = y;
    }

    public Position moveLeft(){
        return new Position(x - 1 , y);
    }

    public Position moveRight(){
        return new Position(x + 1, y);
    }

    public Position moveUp(){
        return new Position(x, y - 1);
    }

    public Position moveDown(){
        return new Position(x, y + 1);
    }

}
