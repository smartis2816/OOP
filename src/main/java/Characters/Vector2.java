package Characters;

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
}
