package Characters.AbstractClasses;

import java.util.ArrayList;

public abstract class Healer extends BasicHero {
    public Healer(int attack, int defence, int shoot, int[] damage, int maxHealth, int currentHealth, int speed,
                  boolean delivery, boolean magic, String name, int amount) {
        super(attack, defence, shoot, damage, maxHealth, currentHealth, speed, delivery, magic, name, amount);
    }

    @Override
    public void step(ArrayList<BasicHero> enemies) {
        BasicHero target = findTargetToHeal();
        if ((float) target.getCurrentHealth() / (float) target.getMaxHealth() <= 0.75)
            target.getHeal(this.getDamage()[0] * amount);
        else {
            int targetIndex = findDeadFriend();
            if (!(targetIndex == -1)) {
                target = band.get(targetIndex);
                target.resurrectHero();
            } else { target = findTargetWithLowestHP(enemies);
                makeHit(target, -(this.getDamage()[0]) * amount);
            }
        }


    }

    private BasicHero findTargetToHeal() {
        BasicHero target = band.get(0);
        float level = (float) target.getCurrentHealth() / (float) target.getMaxHealth();
        for (BasicHero hero : band) {
            if (checkAliveOrDead(hero)) {
                if ((float) hero.getCurrentHealth() / (float) hero.getMaxHealth() < level) target = hero;
            }
        }
        return target;
    }

    private int findDeadFriend() {
        BasicHero target = band.get(0);
        for (int i = 0; i < band.size(); i++) {
            if (checkAliveOrDead(band.get(i))) {
                if (band.get(i).getName().equals("Wizard") || band.get(i).getName().equals("Monk")
                        || band.get(i).getName().equals("Sniper") || band.get(i).getName().equals("Crossbowman")) {
                    return i;
                }
            }
        }
        return -1;
    }

}

