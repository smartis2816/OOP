package Characters;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringJoiner;

public abstract class BasicHero implements HeroActions {
    private int attack;
    private int defence;
    private int shoot;
    private int[] damage;
    private int health;
    private int speed;
    private boolean delivery;
    private boolean magic;
    private String name;
    private String status;
    private int maxHealth;
    private static int idCounter;
    private int playerID;
    protected ArrayList<BasicHero> band;
    protected Vector2 position;

    public BasicHero(int attack, int defence, int shoot, int[] damage, int health, int speed, boolean delivery, boolean magic, String name) {
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
        ArrayList <String> parameters = new ArrayList<>();
        parameters.add(this.name);
        parameters.add(Integer.toString(attack));
        parameters.add(Integer.toString(defence));
        parameters.add(Integer.toString(shoot));
        parameters.add(Arrays.toString(damage));
        parameters.add(Integer.toString(health));
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

    public static String getSpace(int count) {
        return " ".repeat(Math.max(0, count));
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

    public int getPlayerID() {
        return playerID;
    }

}
