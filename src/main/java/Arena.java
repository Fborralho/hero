import com.googlecode.lanterna.TextCharacter;
import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.screen.Screen;

import com.googlecode.lanterna.TextCharacter;

public class Arena {
    private int width;
    private int height;

    private Hero hero;

    public Arena(int width, int height){
        this.width = width;
        this.height = height;
        hero = new Hero(10,10);
    }

    public void moveHero(Position position) {
        if (canHeroMove(position)) {
            hero.setPosition(position);
        }
    }

    private boolean canHeroMove(Position position) {
        return (position.getX() >= 0 && position.getX() < width) &&
                (position.getY() >= 0 && position.getY() < height);
    }


    public void draw(Screen screen){
        screen.setCharacter(hero.position.getX(), hero.position.getY(), TextCharacter.fromCharacter('X')[0]);
    }

    public void processKey(KeyStroke key){
        switch(key.getKeyType()){
            case ArrowUp -> moveHero(hero.moveUp());
            case ArrowDown -> moveHero(hero.moveDown());
            case ArrowLeft -> moveHero(hero.moveLeft());
            case ArrowRight -> moveHero(hero.moveRight());

        }
    }
}


