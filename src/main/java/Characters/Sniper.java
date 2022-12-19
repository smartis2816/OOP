package Characters;

import java.util.ArrayList;

public class Sniper extends BasicHero {
    public Sniper(ArrayList<BasicHero> band, int x, int y) {
        super(12, 10, 32, new int[]{8, 10}, 15, 9, false, false, "Sniper",4);
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
