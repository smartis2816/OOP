import Characters.*;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Random;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
    public static final int BAND_SIZE = 10;
    public static ArrayList<BasicHero> darkTeam;
    public static ArrayList<BasicHero> whiteTeam;
    public static ArrayList<BasicHero> bothSides;

    public static void main(String[] args) {
        initBands();
        Scanner scanner = new Scanner(System.in);

        while (true){
            ConsoleView.view();
            System.out.println("Press ENTER");
            scanner.nextLine();
            turn(darkTeam, whiteTeam);
        }
    }

    public static void initBands() {
        darkTeam = new ArrayList<>();
        whiteTeam = new ArrayList<>();
        Random r = new Random();
        int x = 1;
        int y = 1;
        for (int i = 0; i < BAND_SIZE; i++) {
            switch (r.nextInt(1, 5)) {
                case 1 -> darkTeam.add(new Peasant(darkTeam, x++, y));
                case 2 -> darkTeam.add(new Spearman(darkTeam, x++, y));
                case 3 -> darkTeam.add(new Crossbowman(darkTeam, x++, y));
                case 4 -> darkTeam.add(new Warlock(darkTeam, x++, y));
            }
        }
        x = 1;
        y = 10;
        for (int i = 0; i < BAND_SIZE; i++) {
            switch (r.nextInt(1, 5)) {
                case 1 -> whiteTeam.add(new Peasant(whiteTeam, x++, y));
                case 2 -> whiteTeam.add(new Rogue(whiteTeam, x++, y));
                case 3 -> whiteTeam.add(new Sniper(whiteTeam, x++, y));
                case 4 -> whiteTeam.add(new Monk(whiteTeam, x++, y));
            }
        }
    }

    public static ArrayList<BasicHero> sortBothSides(ArrayList<BasicHero> darkTeam, ArrayList<BasicHero> whiteTeam) {
        bothSides = new ArrayList<>();
        bothSides.addAll(darkTeam);
        bothSides.addAll(whiteTeam);
        bothSides.sort(Comparator.comparing(BasicHero::getPriority).reversed());
        // bothSides.forEach(System.out::println);
        return bothSides;
    }

    public static void turn(ArrayList<BasicHero> darkTeam, ArrayList<BasicHero> whiteTeam) {
        for (BasicHero hero : sortBothSides(darkTeam, whiteTeam)) {
            if (!hero.getStatus().equals("dead"))
                if (hero.getBand().equals(darkTeam)) hero.step(whiteTeam);
                else hero.step(darkTeam);
        }
    }

    public static void printClass(ArrayList<BasicHero> heroes, String className) {
        for (BasicHero item : heroes) {
            if (item.getClass().getSimpleName().equals(className)) {
                System.out.println(item);
            }
        }
    }
}