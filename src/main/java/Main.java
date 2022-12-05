import Characters.*;

import java.util.ArrayList;
import java.util.Random;

public class Main {
    public static final int GANG_SIZE = 10;
    public static void main(String[] args) {

//        ArrayList<FantasyHero> darkTeam = new ArrayList<>();
//        darkTeam.add(new Peasant());
//        darkTeam.add(new Peasant());
//        darkTeam.add(new Rogue());
//        darkTeam.add(new Rogue());
//        darkTeam.add(new Rogue());
//        darkTeam.add(new Sniper());
//        darkTeam.add(new Sniper());
//        darkTeam.add(new Sniper());
//        darkTeam.add(new Warlock());
//        darkTeam.add(new Warlock());
//        darkTeam.forEach(hero -> System.out.println(hero));
//        System.out.println();
//        ArrayList<FantasyHero> whiteTeam = new ArrayList<>();
//        whiteTeam.add(new Peasant());
//        whiteTeam.add(new Peasant());
//        whiteTeam.add(new Rogue());
//        whiteTeam.add(new Rogue());
//        whiteTeam.add(new Spearman());
//        whiteTeam.add(new Spearman());
//        whiteTeam.add(new Crossbowman());
//        whiteTeam.add(new Crossbowman());
//        whiteTeam.add(new Monk());
//        whiteTeam.add(new Monk());
//        whiteTeam.forEach(hero -> System.out.println(hero));
        System.out.println(ConsoleView.top10);

    }

    public static ArrayList<FantasyHero> createRandomHeroes() {
        ArrayList<FantasyHero> heroesRandom = new ArrayList<>();
        Random r = new Random();
        for (int i = 0; i < 50; i++) {
            switch (r.nextInt(1, 8)) {
                case 1 -> heroesRandom.add(new Peasant());
                case 2 -> heroesRandom.add(new Crossbowman());
                case 3 -> heroesRandom.add(new Monk());
                case 4 -> heroesRandom.add(new Rogue());
                case 5 -> heroesRandom.add(new Sniper());
                case 6 -> heroesRandom.add(new Spearman());
                case 7 -> heroesRandom.add(new Warlock());
            }
        }
        return heroesRandom;
    }

    public static void printClass(ArrayList<FantasyHero> heroes, String className) {
        for (FantasyHero item : heroes) {
            if (item.getClass().getSimpleName().equals(className)) {
                System.out.println(item);
            }
        }
    }

}