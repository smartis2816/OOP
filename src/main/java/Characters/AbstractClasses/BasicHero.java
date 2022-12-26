package Characters.AbstractClasses;

import View.Coordinates;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringJoiner;

public abstract class BasicHero implements BasicBehaviour {
    protected String status;
    private int attack;
    private int defence;
    protected int shoot;
    protected int[] damage;
    private int maxHealth;
    private int currentHealth;
    private int speed;
    private boolean delivery;
    private boolean magic;
    private String name;

    protected ArrayList<BasicHero> band;
    protected Coordinates position;
    protected int priority;
    protected int amount;

    public BasicHero(int attack, int defence, int shoot, int[] damage, int maxHealth, int currentHealth, int speed, boolean delivery, boolean magic, String name, int priority, int amount) {
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
        this.priority = priority;
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
//        parameters.add(Integer.toString(attack));
//        parameters.add(Integer.toString(defence));
//        parameters.add(Integer.toString(shoot));
//        parameters.add(Arrays.toString(damage));
        parameters.add(currentHealth + "/" + maxHealth);
        parameters.add(Integer.toString(amount));
//        parameters.add(Integer.toString(speed));
//        parameters.add(String.valueOf(delivery));
//        parameters.add(String.valueOf(magic));

        int countSpaces = 10;
        StringBuilder sb = new StringBuilder();
        sb.append(parameters.get(0));
        sb.append(getSpace(countSpaces + 3 - name.length()));
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

    protected void checkAliveOrDead(BasicHero hero) {
        if (hero.amount <= 0 && hero.currentHealth <= 0) {
            hero.setStatus("Dead");
            hero.currentHealth = 0;
            hero.amount = 0;
        }
    }

    protected BasicHero findTarget(ArrayList<BasicHero> enemies) {
        int targetIndex = 0;
        float minDistance = Float.MAX_VALUE;
        for (int i = 0; i < enemies.size(); i++) {
            if (!enemies.get(i).getStatus().equals("Dead")) {
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
        for (BasicHero hero:enemies) {
            if (hero.currentHealth < target.currentHealth)
                target = hero;
        }
        return target;
    }


    protected void moveWarrior(BasicHero target) {
        int x = this.position.x;
        int y = this.position.y;
        if (target.position.y > this.position.y && checkPosition(x, y++)) {
            this.position.y += 1;
        } else if (target.position.y < this.position.y && checkPosition(x, y--)) {
            this.position.y -= 1;
        } else if (target.position.x > this.position.x && checkPosition(x++, y)) {
            this.position.x += 1;
        } else if (target.position.x < this.position.x && checkPosition(x--, y)) {
            this.position.x -= 1;
        }
    }

    protected void makeShot(BasicHero target) {
        int stackHP = (target.amount - 1) * target.maxHealth + target.currentHealth;
        int damageValue = getDamageValue(target);
        float distance = this.getPosition().getDistance(target);
        if (this.getSpeed() > distance) {
            stackHP -= damageValue;
            target.amount = stackHP / target.maxHealth;
            if (stackHP % target.maxHealth != 0)
                target.currentHealth = stackHP - target.amount * target.maxHealth;
        } else {
            stackHP -= damageValue / 2;
            target.amount = stackHP / target.maxHealth;
            if (stackHP % target.maxHealth != 0)
                target.currentHealth = stackHP - target.amount * target.maxHealth;
                target.amount += 1;
        }
        checkAliveOrDead(target);
    }

    protected void makeHit(BasicHero target, int damageValue) {
        int stackHP = (target.amount - 1) * target.maxHealth + target.currentHealth;
        stackHP -= damageValue;
        target.amount = stackHP / target.maxHealth;
        if (stackHP % target.maxHealth != 0) {
            target.currentHealth = stackHP - target.amount * target.maxHealth;
            target.amount += 1;
        }
        checkAliveOrDead(target);
    }

    protected void getHeal(int heal) {
        this.currentHealth -= heal;
        if (this.currentHealth > this.maxHealth) this.currentHealth = this.maxHealth;
    }

    protected void resurrectHero() {
        this.amount = 1;
        this.currentHealth = 1;
    }


    protected boolean checkPosition(int x, int y) {
        Coordinates position = new Coordinates(x, y);
        for (BasicHero hero:band) {
            if (position.isEqual(hero.position)) return false;
        }
        return true;
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

    public void setPosition(int x, int y) {
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

    public void setHealth(int num) {
        this.currentHealth = num;
    }

    public int getPriority() {
        return priority;
    }

    public String getStatus() {
        return status;
    }

    public ArrayList<BasicHero> getBand() {
        return band;
    }

    public void setStatus(String status) {
        this.status = status;
    }


}
