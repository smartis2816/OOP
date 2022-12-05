package Characters;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringJoiner;

public abstract class FantasyHero implements HeroActions {
    private int attack;
    private int defence;
    private int shoot;
    private int[] damage;
    private int health;
    private int speed;
    private boolean delivery;
    private boolean magic;
    private String name;
    private int maxHealth;

    public FantasyHero(int attack, int defence, int shoot, int[] damage, int health, int speed, boolean delivery, boolean magic, String name) {
        this.attack = attack;
        this.defence = defence;
        this.shoot = shoot;
        this.damage = damage;
        this.health = health;
        this.speed = speed;
        this.delivery = delivery;
        this.magic = magic;
        this.name = name;
        this.maxHealth = health;
    }

    public void step(ArrayList<FantasyHero> band) {
    }

    public String getInfo() {
        return new StringJoiner(", ", this.getClass().getSimpleName() + " [", "]")
                .add("attack = " + attack)
                .add("defence = " + defence)
                .add("shoot = " + shoot)
                .add("damage = " + Arrays.toString(damage))
                .add("health = " + health)
                .add("speed = " + speed)
                .add("delivery = " + delivery)
                .add("magic = " + magic)
                .toString();
    }

    @Override
    public String toString() {
        return this.getInfo();
    }

    public int getCurrentHealth() {
        return health;
    }

    public int getMaxHealth() {
        return maxHealth;
    }

    public int[] getDamage() {
        return damage;
    }

    public void setHealth(int health) {
        this.health = health;
    }
}
