package Characters;

import java.util.ArrayList;


public class Monk extends BasicHero {
    public Monk(ArrayList<BasicHero> band, int x, int y) {
        super(12, 7, 0, new int[]{-4, -4}, 30, 5, false, true, "Monk",2);
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
