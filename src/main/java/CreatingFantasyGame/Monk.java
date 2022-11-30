package CreatingFantasyGame;

import java.util.ArrayList;


public class Monk extends FantasyHero {
    public Monk() {
        super(12, 7, 0, new int[]{-4, -4}, 30, 5, false, true, "");
    }

    @Override
    public void step(ArrayList<FantasyHero> band) {
        FantasyHero target = band.get(0);
        for (FantasyHero hero : band) {
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
