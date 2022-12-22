package Characters;

import Characters.AbstractClasses.BasicHero;
import Characters.AbstractClasses.Healer;
import View.Coordinates;

import java.util.ArrayList;

public class Warlock extends Healer {
    public Warlock(ArrayList<BasicHero> band, int x, int y) {
        super(17, 12, 0, new int[]{-5, -5}, 30, 30, 9, true, false, "Warlock", 2);
        super.band = band;
        super.position = new Coordinates(x, y);
    }
}
