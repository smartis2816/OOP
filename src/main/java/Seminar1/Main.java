package Seminar1;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ArrayList<FantasyHero> heroes = new ArrayList<>();
        heroes.add(new Peasant());
        heroes.add(new Crossbowman());
        heroes.add(new Monk());
        heroes.add(new Rogue());
        heroes.add(new Sniper());
        heroes.add(new Spearman());
        heroes.add(new Warlock());

        heroes.forEach(item -> System.out.println(item));
    }
}
