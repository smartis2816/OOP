package Characters.AbstractClasses;

import java.util.ArrayList;

public interface BasicBehaviour {
    String getInfo();
    void step(ArrayList<BasicHero> enemies);
}
