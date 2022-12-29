package Characters.AbstractClasses;

import View.Coordinates;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringJoiner;

public abstract class BasicHero implements BasicBehaviour {
    protected String status;
    private final int attack;
    private final int defence;
    protected int shoot;
    protected int[] damage;
    private final int maxHealth;
    private int currentHealth;
    private final int speed;
    private final boolean delivery;
    private final boolean magic;
    private final String name;

    protected ArrayList<BasicHero> band;
    protected Coordinates position;
    protected int amount;

    public BasicHero(int attack, int defence, int shoot, int[] damage, int maxHealth, int currentHealth, int speed, boolean delivery, boolean magic, String name, int amount) {
        this.attack = attack;
        this.defence = defence;
        this.shoot = shoot;
        this.damage = damage;
        this.maxHealth = maxHealth;
        this.currentHealth = currentHealth;
        this.speed = speed;
        this.delivery = delivery;
        this.magic = magic;
        this.name = name;
        this.status = "Ready";
        this.amount = amount;
    }

    public void step(ArrayList<BasicHero> band) {
    }

    public String getInfo() {
        return new StringJoiner(", ", this.getClass().getSimpleName() + " [", "]")
                .add("attack = " + attack)
                .add("defence = " + defence)
                .add("shoot = " + shoot)
                .add("damage = " + Arrays.toString(damage))
                .add("health = " + maxHealth)
                .add("speed = " + speed)
                .add("delivery = " + delivery)
                .add("magic = " + magic)
                .toString();
    }

    public String getParameters() {
        ArrayList<String> parameters = new ArrayList<>();
        parameters.add(this.name);
        parameters.add(status);
        parameters.add(currentHealth + "/" + maxHealth);
        parameters.add(Integer.toString(amount));
        int countSpaces = 12;
        StringBuilder sb = new StringBuilder();
        sb.append(parameters.get(0));
        sb.append(getSpace(countSpaces + 1 - name.length()));
        for (int i = 1; i < parameters.size(); i++) {
            sb.append(parameters.get(i));
            sb.append(getSpace(countSpaces - parameters.get(i).length()));
        }
        return sb.toString();
    }

    public static String getSpace(int count) {
        return " ".repeat(Math.max(0, count));
    }

    protected int getDamageValue(BasicHero target) {
        int power = this.attack - target.getDefence();
        int damageValue = 0;
        if (power == 0) damageValue = (this.damage[0] + this.damage[1]) / 2;
        if (power > 0) damageValue = this.damage[1];
        if (power < 0) damageValue = this.damage[0];
        return damageValue * amount;
    }

    protected void checkHP(BasicHero hero, int stackHP) {
        if (stackHP <= 0) {
            hero.setStatus("Dead");
            stackHP = 0;
            hero.currentHealth = 0;
            hero.amount = 0;
        }
    }

    protected boolean checkAliveOrDead(BasicHero hero) {
        return (!hero.getStatus().equals("Dead"));
    }


    protected BasicHero findTarget(ArrayList<BasicHero> enemies) {
        int targetIndex = 0;
        float minDistance = Float.MAX_VALUE;
        for (int i = 0; i < enemies.size(); i++) {
            if (checkAliveOrDead(enemies.get(i))) {
                float distance = getPosition().getDistance(enemies.get(i));
                if (minDistance > distance) {
                    minDistance = distance;
                    targetIndex = i;
                }
            }
        }
        return enemies.get(targetIndex);
    }

    protected BasicHero findTargetWithLowestHP(ArrayList<BasicHero> enemies) {
        BasicHero target = enemies.get(0);
        for (BasicHero hero : enemies) {
            if (hero.currentHealth < target.currentHealth)
                target = hero;
        }
        return target;
    }


    protected void moveWarrior(BasicHero target) {
        int x = this.position.x;
        int y = this.position.y;
        if (target.position.y > this.position.y && checkPosition(x, y + 1)) {
            this.setPosition(x, y + 1);
        } else if (target.position.y < this.position.y && checkPosition(x, y - 1)) {
            this.setPosition(x, y - 1);
        } else if (target.position.x > this.position.x && checkPosition(x + 1, y)) {
            this.setPosition(x + 1, y);
        } else if (target.position.x < this.position.x && checkPosition(x - 1, y)) {
            this.setPosition(x - 1, y);
        }
    }

    protected boolean checkPosition(int x, int y) {
        Coordinates position = new Coordinates(x, y);
        for (int i = 0; i < 10; i++)
            if (position.isEqual(this.band.get(i).getPosition())) return false;
        return true;
    }


    protected void makeHit(BasicHero target, int damageValue) {
        int stackHP = (target.amount - 1) * target.maxHealth + target.currentHealth;
        stackHP -= damageValue;
        target.amount = stackHP / target.maxHealth;
        if (stackHP % target.maxHealth != 0) {
            target.currentHealth = stackHP - target.amount * target.maxHealth;
            target.amount += 1;
        }
        checkHP(target, stackHP);
    }

    protected void getHeal(int heal) {
        this.currentHealth -= heal;
        if (this.currentHealth > this.maxHealth) this.currentHealth = this.maxHealth;
    }

    protected void resurrectHero() {
        this.amount = 1;
        this.currentHealth = 1;
    }

    public int getSpeed() {
        return speed;
    }

    @Override
    public String toString() {
        return this.getInfo();
    }

    public Coordinates getPosition() {
        return this.position;
    }

    private void setPosition(int x, int y) {
        this.position.x = x;
        this.position.y = y;
    }

    public String getName() {
        return name;
    }

    public int getDefence() {
        return defence;
    }

    public int getCurrentHealth() {
        return currentHealth;
    }

    public int getMaxHealth() {
        return maxHealth;
    }

    public int[] getDamage() {
        return damage;
    }


    public String getStatus() {
        return status;
    }


    public void setStatus(String status) {
        this.status = status;
    }


}
