package Characters;

import java.util.ArrayList;

public class Crossbowman extends BasicHero {
    public Crossbowman(ArrayList<BasicHero> band, int x, int y) {
        super(6, 3, 16, new int[]{2, 3}, 10, 4, false, false, "Crossbowman");
        super.band = band;
        super.position = new Vector2(x, y);
    }

    @Override
    public void step(ArrayList<BasicHero> band) {

    }
}
