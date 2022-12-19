package Characters;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringJoiner;

public abstract class BasicHero implements HeroActions {
    private int attack;
    private int defence;
    protected int shoot;
    protected int[] damage;
    private int health;
    private int speed;
    private boolean delivery;
    private boolean magic;
    private String name;
    protected String status;
    private int maxHealth;
    private static int idCounter;
    private int playerID;
    protected ArrayList<BasicHero> band;
    protected Vector2 position;
    protected int priority;

    public BasicHero(int attack, int defence, int shoot, int[] damage, int health, int speed, boolean delivery, boolean magic, String name, int priority) {
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
        this.status = "stand";
        this.priority = priority;
        playerID = idCounter++;
    }

    public void step(ArrayList<BasicHero> band) {
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

    public String getParameters() {
        ArrayList<String> parameters = new ArrayList<>();
        parameters.add(this.name);
        parameters.add(status);
        parameters.add(Integer.toString(attack));
        parameters.add(Integer.toString(defence));
        parameters.add(Integer.toString(shoot));
        parameters.add(Arrays.toString(damage));
        parameters.add(Integer.toString(getCurrentHealth()));
        parameters.add(Integer.toString(speed));
        parameters.add(String.valueOf(delivery));
        parameters.add(String.valueOf(magic));
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

    protected int getDamageValue(BasicHero target) {
        int power = this.attack - target.getDefence();
        int damageValue = 0;
        if (power == 0) damageValue = (this.damage[0] + this.damage[1]) / 2;
        if (power > 0) damageValue = this.damage[1];
        if (power < 0) damageValue = this.damage[0];
        return damageValue;
    }

    protected void checkAliveOrDead(BasicHero hero){
        if (this.getCurrentHealth() <= 0) {
            this.status = "dead";
            this.health = 0;
        }
    }

    public static String getSpace(int count) {
        return " ".repeat(Math.max(0, count));
    }

    public int getSpeed() {
        return speed;
    }

    @Override
    public String toString() {
        return this.getInfo();
    }

    public Vector2 getPosition() {
        return position;
    }

    public String getName() {
        return name;
    }

    public int getDefence() {
        return defence;
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

    public int getPriority() {
        return priority;
    }

    public String getStatus() {
        return status;
    }

    public ArrayList<BasicHero> getBand() {
        return band;
    }
}
