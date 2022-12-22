package Characters.AbstractClasses;

import java.util.ArrayList;

public abstract class Shooter extends BasicHero {
    public Shooter(int attack, int defence, int shoot, int[] damage, int maxHealth, int currentHealth, int speed,
                   boolean delivery, boolean magic, String name, int priority) {
        super(attack, defence, shoot, damage, maxHealth, currentHealth, speed, delivery, magic, name, priority);
    }
    @Override
    public void step(ArrayList<BasicHero> enemies) {
        for (BasicHero hero : this.band) {
            if (hero.getName().equals("Peasant") && hero.getStatus().equals("stand")) {
                this.shoot++;
                hero.setStatus("used");
                break;
            }
        }
        if (this.shoot < 1) return;
        BasicHero target = findTarget(enemies);
        makeShot(target);
        this.shoot--;
    }
}
