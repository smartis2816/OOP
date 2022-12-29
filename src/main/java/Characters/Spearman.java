package Characters;

import Characters.AbstractClasses.BasicHero;
import Characters.AbstractClasses.Warrior;
import View.Coordinates;

import java.util.ArrayList;

public class Spearman extends Warrior {
    public Spearman(ArrayList<BasicHero> band, int x, int y, int amount) {
        super(4, 5, 0, new int[]{1, 3}, 10, 10, 4, false, false, "Spearman", amount);
        super.band = band;
        super.position = new Coordinates(x, y);
    }
}
