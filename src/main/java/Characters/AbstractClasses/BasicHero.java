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

    public BasicHero(int attack, int defence, int shoot, int[] damage, int maxHealth, int currentHealth, int speed, boolean delivery, boolean magic, String name, int priority) {
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
        return damageValue;
    }

    protected void checkAliveOrDead(BasicHero hero) {
        if (hero.getCurrentHealth() <= 0) {
            hero.setStatus("Dead");
            hero.setHealth(0);
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

    protected void moveWarrior(BasicHero target) {
        int x = this.getPosition().x;
        int y = this.getPosition().y;
        if (target.getPosition().y > this.position.y && checkPosition(x, y++)) {
            this.setPosition(x, y++);
        } else if (target.getPosition().y < this.position.y && checkPosition(x, y--)) {
            this.setPosition(x, y--);
        } else if (target.getPosition().x > this.position.x && checkPosition(x++, y)) {
            this.setPosition(x++, y);
        } else if (target.getPosition().x < this.position.x && checkPosition(x--, y)) {
            this.setPosition(x--, y);
        }
    }

    protected void makeShot(BasicHero target) {
        int damageValue = getDamageValue(target);
        float distance = this.getPosition().getDistance(target);
        if (this.getSpeed() > distance)
            target.setHealth(target.getCurrentHealth() - damageValue);
        else target.setHealth((target.getCurrentHealth() - damageValue / 2));
        checkAliveOrDead(target);
    }

    protected void makeHit(BasicHero target) {
        int damageValue = getDamageValue(target);
        target.setHealth(target.getCurrentHealth() - damageValue);
        checkAliveOrDead(target);
    }

    protected boolean checkPosition(int x, int y) {
        Coordinates position = new Coordinates(x, y);
        for (int i = 0; i < 10; i++) {
            if (position.isEqual(this.band.get(i).getPosition())) return false;
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
        return position;
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

    public void setHealth(int amount) {
        this.currentHealth = amount;
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
