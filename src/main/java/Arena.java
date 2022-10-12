import com.googlecode.lanterna.*;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.screen.Screen;

import com.googlecode.lanterna.TextCharacter;
import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

public class Arena {
    private final List<Wall> walls;
    private int width;
    private int height;

    private Screen screen;
    private Hero hero;
    TextGraphics graphics;
    {graphics = screen.newTextGraphics();}
    public Arena(int width, int height){
        this.width = width;
        this.height = height;
        hero = new Hero(10,10);
        this.walls = createWalls();

    }

    public void moveHero(Position position) {
        if (canHeroMove(position)) {
            hero.setPosition(position);
        }
    }

    private boolean canHeroMove(Position position) {
        return (position.getX() >= 0 && position.getX() < width) &&
                (position.getY() >= 0 && position.getY() < height) &&
                !walls.contains(new Wall(position.getX(), position.getY()));
    }


    public void draw(TextGraphics graphics){
        graphics.setBackgroundColor(TextColor.Factory.fromString("#336699"));
        graphics.fillRectangle(new TerminalPosition(0,0), new TerminalSize(width,height), ' ');
    }

    public void processKey(KeyStroke key){
        switch(key.getKeyType()){
            case ArrowUp -> moveHero(hero.moveUp());
            case ArrowDown -> moveHero(hero.moveDown());
            case ArrowLeft -> moveHero(hero.moveLeft());
            case ArrowRight -> moveHero(hero.moveRight());

        }
    }


    private List<Wall> createWalls(){
        List<Wall> walls = new ArrayList<>();
        for(int c = 0; c < width ; c++){
            walls.add(new Wall(c, 0));
            walls.add(new Wall(c, height-1));
        }
        for(int r = 1; r < height ; r++){
            walls.add(new Wall(0, r));
            walls.add(new Wall(width - 1, r));
        }
        return walls;
    }

}


