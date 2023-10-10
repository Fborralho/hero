package com.Fborralho.hero;

import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.TextCharacter;
import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.input.KeyType;
import com.googlecode.lanterna.screen.Screen;
import com.googlecode.lanterna.screen.TerminalScreen;
import com.googlecode.lanterna.terminal.DefaultTerminalFactory;
import com.googlecode.lanterna.terminal.Terminal;

import javax.swing.*;
import java.io.IOException;
import java.sql.SQLOutput;

public class Game {
    private int x = 10;
    private int y = 10;

    public Game(){
    }

    private void processKey(KeyStroke key){
        if(key.getKeyType() == KeyType.ArrowDown){
            y +=  1;
        }
        if(key.getKeyType() == KeyType.ArrowUp){
            y -= 1;
        }
        if(key.getKeyType() == KeyType.ArrowLeft){
            x -= 1;
        }
        if(key.getKeyType() == KeyType.ArrowRight){
            x += 1;
        }
    }
    private void draw () throws IOException{




    }

    public void run() throws IOException {
        TerminalSize terminalSize = new TerminalSize(40,20);
        DefaultTerminalFactory terminalFactory = new DefaultTerminalFactory().setInitialTerminalSize(terminalSize);
        Terminal terminal = new DefaultTerminalFactory().createTerminal();
        Screen screen = new TerminalScreen(terminal);
        screen.setCursorPosition(null);
        screen.startScreen();
        screen.doResizeIfNecessary();
        screen.setCharacter(x,y, TextCharacter.fromCharacter('X')[0]);
        while(true){
            KeyStroke key = screen.readInput();
            screen.clear();
            processKey(key);
            screen.setCharacter(x,y,TextCharacter.fromCharacter('X')[0]);
            screen.refresh();

            if(key.getKeyType() == KeyType.Character && key.getCharacter() == 'q'){
                screen.close();
            }
            if(key.getKeyType() == KeyType.EOF){
                break;
            }
        }
    }



}
