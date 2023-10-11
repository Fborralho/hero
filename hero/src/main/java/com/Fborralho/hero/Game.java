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
    Hero hero = new Hero(new Position(10,10));
    Arena arena = new Arena(10, 10, hero);

    public Game(){
    }

    private void processKey(KeyStroke key){
        arena.processKey(key);
    }


    public void run() throws IOException {
        TerminalSize terminalSize = new TerminalSize(arena.getWidth(),arena.getHeight());
        DefaultTerminalFactory terminalFactory = new DefaultTerminalFactory().setInitialTerminalSize(terminalSize);
        Terminal terminal = new DefaultTerminalFactory().createTerminal();
        Screen screen = new TerminalScreen(terminal);
        screen.setCursorPosition(null);
        screen.startScreen();
        screen.doResizeIfNecessary();
        arena.draw(screen);
        while(true){
            KeyStroke key = screen.readInput();
            screen.clear();
            processKey(key);
            arena.draw(screen);
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
