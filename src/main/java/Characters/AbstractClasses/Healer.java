package Characters.AbstractClasses;

import java.util.ArrayList;

public abstract class Healer extends BasicHero{
    public Healer(int attack, int defence, int shoot, int[] damage, int maxHealth, int currentHealth, int speed,
                   boolean delivery, boolean magic, String name, int priority) {
        super(attack, defence, shoot, damage, maxHealth, currentHealth, speed, delivery, magic, name, priority);
    }
    @Override
    public void step(ArrayList<BasicHero> enemies) {
        BasicHero target = band.get(0);
        for (BasicHero hero : band) {
            if (!hero.getStatus().equals("Dead")){
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
}
