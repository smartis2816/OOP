package Characters;

import java.util.ArrayList;
import java.util.Objects;

public class Vector2 {
    public int x, y;

    public Vector2(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public boolean isEqual(Vector2 position) {
        if (position.x == x & position.y == y) return true;
        else return false;
    }

    public float getDistance(BasicHero hero){
        return (float)Math.sqrt(Math.pow((this.x - hero.getPosition().x), 2) + Math.pow((this.y - hero.getPosition().y), 2));
    }

//    public BasicHero getTarget(BasicHero hero, ArrayList<BasicHero> enemyBand){
//        int targetIndex = 0;
//        float distance = hero.getPosition().getDistance(enemyBand.get(0));
//        for (int i = 0; i < enemyBand.size(); i++) {
//            if (!enemyBand.get(i).status.equals("dead")) {
//                if (this.getPosition().getDistance(enemyBand.get(i)) < distance) {
//                    distance = this.getPosition().getDistance(enemyBand.get(i));
//                    targetIndex = i;
//                }
//            }
//        }
//    }
}
