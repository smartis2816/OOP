package Seminar1;

import java.util.ArrayList;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        ArrayList<FantasyHero> heroes = new ArrayList<>(); // лист для ручного заполнения героями
        heroes.add(new Peasant());
        heroes.add(new Crossbowman());
        heroes.add(new Monk());
        heroes.add(new Rogue());
        heroes.add(new Sniper());
        heroes.add(new Spearman());
        heroes.add(new Warlock());

        heroes.forEach(item -> System.out.println(item));

        ArrayList<FantasyHero> heroesRandomSquad = createRandomHeroes(); // Список из 50 рандомных персонажей
        heroesRandomSquad.forEach(item -> System.out.println(item));
        System.out.println();
        printClass(heroesRandomSquad, "Monk"); // Вывод в консоль информации по определённому классу (на примере Monk)


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