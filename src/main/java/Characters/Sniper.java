package Characters;

import Characters.AbstractClasses.BasicHero;
import Characters.AbstractClasses.Shooter;
import View.Coordinates;

import java.util.ArrayList;

public class Sniper extends Shooter {
    public Sniper(ArrayList<BasicHero> band, int x, int y) {
        super(12, 10, 32, new int[]{8, 10}, 15, 15, 9, false, false, "Sniper", 4);
        super.band = band;
        super.position = new Coordinates(x, y);
    }
}
