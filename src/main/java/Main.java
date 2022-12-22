import Characters.AbstractClasses.BasicHero;
import Characters.*;

import java.util.*;

public class Main {
    public static final int BAND_SIZE = 10;
    public static ArrayList<BasicHero> darkTeam;
    public static ArrayList<BasicHero> whiteTeam;
    public static ArrayList<BasicHero> bothSides;

    public static void main(String[] args) {
        initBands();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            ConsoleView.view();
            System.out.println("Press ENTER");
            scanner.nextLine();
            makeTurn(darkTeam, whiteTeam);
            //darkTeam.forEach(hero -> hero.step(whiteTeam));
            //whiteTeam.forEach(hero -> hero.step(darkTeam));
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

    public static void makeTurn(ArrayList<BasicHero> darkTeam, ArrayList<BasicHero> whiteTeam) {
        for (BasicHero hero : darkTeam) {
            if (hero.getName().equals("Crossbowman")) hero.step(whiteTeam);
        }
        for (BasicHero hero : whiteTeam) {
            if (hero.getName().equals("Sniper")) hero.step(darkTeam);
        }
        for (BasicHero hero : darkTeam) {
            if (hero.getName().equals("Spearman")) hero.step(whiteTeam);
        }
        for (BasicHero hero : whiteTeam) {
            if (hero.getName().equals("Rogue")) hero.step(darkTeam);
        }
        for (BasicHero hero : darkTeam) {
            if (hero.getName().equals("Warlock")) hero.step(whiteTeam);
        }
        for (BasicHero hero : whiteTeam) {
            if (hero.getName().equals("Monk")) hero.step(darkTeam);
        }
        for (BasicHero hero : darkTeam) {
            if (hero.getName().equals("Peasant")) hero.step(whiteTeam);
        }
        for (BasicHero hero : whiteTeam) {
            if (hero.getName().equals("Peasant")) hero.step(darkTeam);
        }
    }
    /*
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
    */
}