package com.Fborralho.hero;

import com.googlecode.lanterna.TextCharacter;
import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.input.KeyType;
import com.googlecode.lanterna.screen.Screen;

import javax.swing.*;
import java.io.IOException;

public class Arena {
    private int width;
    private int height;
    private Hero hero;
    public int getWidth(){
        return width;
    }
    public int getHeight(){
        return height;
    }
    public Arena(int width, int height, Hero hero){
        this.width = width;
        this.height = height;
        this.hero  = hero;
    }
    public void draw(Screen screen) throws IOException {
        screen.setCharacter(hero.getPosition().getX(), hero.getPosition().getY(), TextCharacter.fromCharacter('X')[0]);
    }
    public void processKey(KeyStroke key){
        if(key.getKeyType() == KeyType.ArrowDown){
            moveHero(hero.getPosition().moveDown());
        }
        if(key.getKeyType() == KeyType.ArrowUp){
            moveHero(hero.getPosition().moveUp());
        }
        if(key.getKeyType() == KeyType.ArrowLeft){
            moveHero(hero.getPosition().moveLeft());
        }
        if(key.getKeyType() == KeyType.ArrowRight){
            moveHero(hero.getPosition().moveRight());
        }
    }
    private boolean canHeroMove(Position position){
        if(position.getX()<= width && position.getY()<= height){
            return true;
        }
        return false;
    }
    public void moveHero(Position position){
        if(canHeroMove(position)){
            hero.setPosition(position);
        }
    }
}
