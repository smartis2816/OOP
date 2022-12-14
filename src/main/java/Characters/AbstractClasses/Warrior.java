package Characters.AbstractClasses;

import java.util.ArrayList;

public abstract class Warrior extends BasicHero {
    public Warrior(int attack, int defence, int shoot, int[] damage, int maxHealth, int currentHealth, int speed,
                   boolean delivery, boolean magic, String name, int amount) {
        super(attack, defence, shoot, damage, maxHealth, currentHealth, speed, delivery, magic, name, amount);
    }

    @Override
    public void step(ArrayList<BasicHero> enemies) {
        BasicHero target = findTarget(enemies);
        moveWarrior(target);
        int damageVal = getDamageValue(target);
        if ((int)this.getPosition().getDistance(target) <= 1) makeHit(target, damageVal);
    }

}
