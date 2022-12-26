package Characters;

import Characters.AbstractClasses.BasicHero;
import Characters.AbstractClasses.Shooter;
import View.Coordinates;

import java.util.ArrayList;

public class Crossbowman extends Shooter {
    public Crossbowman(ArrayList<BasicHero> band, int x, int y, int amount) {
        super(6, 3, 16, new int[]{2, 3}, 10, 10, 4, false, false, "Crossbowman", 4, amount);
        super.band = band;
        super.position = new Coordinates(x, y);
    }
}
