package Characters;

import java.util.ArrayList;

public class Crossbowman extends BasicHero {
    public Crossbowman(ArrayList<BasicHero> band, int x, int y) {
        super(6, 3, 16, new int[]{2, 3}, 10, 4, false, false, "Crossbowman",4);
        super.band = band;
        super.position = new Vector2(x, y);
    }

    @Override
    public void step(ArrayList<BasicHero> enemies) {
        for (BasicHero hero : this.band) {
            if (hero.getName().equals("Peasant") && hero.status.equals("stand")) {
                this.shoot++;
                hero.status = "used";
                break;
            }
        }
        if (this.shoot < 1) return;
        int targetIndex = 0;
        double distance = this.getPosition().getDistance(band.get(0));
        for (int i = 0; i < enemies.size(); i++) {
            if (!enemies.get(i).status.equals("dead")) {
                if (this.getPosition().getDistance(enemies.get(i)) < distance) {
                    distance = this.getPosition().getDistance(enemies.get(i));
                    targetIndex = i;
                }
            }
        }
        BasicHero enemy = enemies.get(targetIndex);
        if (this.getSpeed() > distance)
            enemy.setHealth(getCurrentHealth() - getDamageValue(enemy));
        else enemy.setHealth((getCurrentHealth() - getDamageValue(enemy)) / 2);
        checkAliveOrDead(enemy);
        this.shoot--;
    }
}
