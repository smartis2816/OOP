package Characters;

import java.util.ArrayList;

public class Warlock extends BasicHero {
    public Warlock(ArrayList<BasicHero> band, int x, int y) {
        super(17, 12, 0, new int[]{-5, -5}, 30, 9, true, false, "Warlock",2);
        super.band = band;
        super.position = new Vector2(x, y);
    }

    @Override
    public void step(ArrayList<BasicHero> enemies) {
        BasicHero target = band.get(0);
        for (BasicHero hero : band) {
            if (hero.getCurrentHealth() < hero.getMaxHealth() && hero.getCurrentHealth() < target.getCurrentHealth()) {
                target = hero;
            }
            hero.setHealth(getCurrentHealth() - getDamage()[0]);
            if (hero.getCurrentHealth() > hero.getMaxHealth()) {
                hero.setHealth(hero.getMaxHealth());
            }
        }
    }
}
