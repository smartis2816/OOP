package CreatingFantasyGame;

import java.util.ArrayList;

public class Warlock extends FantasyHero{
    public Warlock() {
        super(17, 12, 0, new int[]{-5, -5}, 30, 9, true, false, "");
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
