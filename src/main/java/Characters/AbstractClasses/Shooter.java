package Characters.AbstractClasses;

import java.util.ArrayList;

public abstract class Shooter extends BasicHero {
    public Shooter(int attack, int defence, int shoot, int[] damage, int maxHealth, int currentHealth, int speed,
                   boolean delivery, boolean magic, String name, int amount) {
        super(attack, defence, shoot, damage, maxHealth, currentHealth, speed, delivery, magic, name, amount);
    }

    @Override
    public void step(ArrayList<BasicHero> enemies) {
        findArrows(this.band);
        if (this.shoot < 1) return;
        BasicHero target = findTarget(enemies);
        int damageValue = getDamageLevel(target);
        this.makeHit(target, damageValue);
        this.shoot--;
    }

    private void findArrows(ArrayList<BasicHero> band) {
        for (BasicHero hero : band) {
            if (hero.getName().equals("Peasant") && hero.getStatus().equals("Stand")) {
                this.shoot++;
                hero.setStatus("Used");
                break;
            }
        }
    }

    private int getDamageLevel(BasicHero target) {
        float distance = this.position.getDistance(target);
        int damageValue = getDamageValue(target);
        if (this.getSpeed() < distance)
            damageValue /= 2;
        return damageValue;
    }
}
