package Characters;

import Characters.AbstractClasses.BasicHero;
import View.Coordinates;

import java.util.ArrayList;

public class Peasant extends BasicHero {
    public Peasant(ArrayList<BasicHero> band, int x, int y) {
        super(1, 1, 0, new int[]{1, 1}, 1, 1, 3, true, false, "Peasant", 1);
        super.band = band;
        super.position = new Coordinates(x, y);
    }

    @Override
    public void step(ArrayList<BasicHero> band) {
        if (this.status.equals("used")) this.status = "stand";
    }
}
