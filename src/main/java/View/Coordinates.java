package View;

import Characters.AbstractClasses.BasicHero;

public class Coordinates {
    public int x, y;

    public Coordinates(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public boolean isEqual(Coordinates position) {
        if (position.x == x & position.y == y) return true;
        else return false;
    }

    public float getDistance(BasicHero hero){
        return (float)Math.sqrt(Math.pow((this.x - hero.getPosition().x), 2) + Math.pow((this.y - hero.getPosition().y), 2));
    }

}