package com.Fborralho.hero;

import com.googlecode.lanterna.TextCharacter;
import com.googlecode.lanterna.screen.Screen;

import java.io.IOException;

public class Hero {
    private Position position;

    public void setPosition(Position position){
        this.position = position;
    }
    public Position getPosition(){
        return position;
    }
    public Hero(Position position){
        setPosition(position);
    }

    public void moveUp() {
        this.position = this.position.moveUp();
    }

    public void moveDown() {
        this.position = this.position.moveDown();
    }

    public void moveLeft() {
        this.position = this.position.moveLeft();
    }

    public void moveRight() {
        this.position = this.position.moveRight();
    }
}
