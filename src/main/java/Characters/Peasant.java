package Characters;

import java.util.ArrayList;

public class Peasant extends BasicHero {
    public Peasant(ArrayList<BasicHero> band, int x, int y) {
        super(1, 1, 0, new int[]{1, 1}, 1, 3, true, false, "Peasant");
        super.band = band;
        super.position = new Vector2(x, y);
    }

    @Override
    public void step(ArrayList<BasicHero> band) {

    }
}