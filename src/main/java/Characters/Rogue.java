package Characters;

import Characters.AbstractClasses.BasicHero;
import Characters.AbstractClasses.Warrior;
import View.Coordinates;

import java.util.ArrayList;

public class Rogue extends Warrior {
    public Rogue(ArrayList<BasicHero> band, int x, int y) {
        super(8, 3, 0, new int[]{2, 4}, 10, 10, 6, false, false, "Rogue", 3);
        super.band = band;
        super.position = new Coordinates(x, y);
    }
}