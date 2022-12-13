package Characters;

import java.util.ArrayList;

public class Sniper extends BasicHero {
    public Sniper(ArrayList<BasicHero> band, int x, int y) {
        super(12, 10, 32, new int[]{8, 10}, 15, 9, false, false, "Sniper");
        super.band = band;
        super.position = new Vector2(x, y);
    }

    @Override
    public void step(ArrayList<BasicHero> band) {
    }
}
