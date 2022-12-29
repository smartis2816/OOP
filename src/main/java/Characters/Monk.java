package Characters;

import Characters.AbstractClasses.BasicHero;
import Characters.AbstractClasses.Healer;
import View.Coordinates;

import java.util.ArrayList;


public class Monk extends Healer {
    public Monk(ArrayList<BasicHero> band, int x, int y, int amount) {
        super(12, 7, 0, new int[]{-4, -4}, 30, 30, 5, false, true, "Monk", amount);
        super.band = band;
        super.position = new Coordinates(x, y);
    }
}
