package Characters;

import java.util.ArrayList;

public class Spearman extends BasicHero {
    public Spearman(ArrayList<BasicHero> band, int x, int y) {
        super(4, 5, 0, new int[]{1, 3}, 10, 4, false, false, "Spearman",3);
        super.band = band;
        super.position = new Vector2(x, y);
    }

    @Override
    public void step(ArrayList<BasicHero> band) {

    }
}
