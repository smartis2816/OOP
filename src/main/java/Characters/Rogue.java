package Characters;

import java.util.ArrayList;

public class Rogue extends BasicHero {
    public Rogue(ArrayList<BasicHero> band, int x, int y) {
        super(8, 3, 0, new int[]{2, 4}, 10, 6, false, false, "Rogue");
        super.band = band;
        super.position = new Vector2(x, y);
    }

    @Override
    public void step(ArrayList<BasicHero> band) {

    }
}
