import Characters.AbstractClasses.BasicHero;
import Characters.*;

import java.util.*;

public class Main {
    public static final int BAND_SIZE = 10;
    public static ArrayList<BasicHero> darkBand;
    public static ArrayList<BasicHero> whiteBand;

    public static void main(String[] args) {
        initBands();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            ConsoleView.view();
            System.out.println("Press ENTER");
            scanner.nextLine();
            makeTurn(darkBand, whiteBand);
        }
    }

    public static void initBands() {
        darkBand = new ArrayList<>();
        whiteBand = new ArrayList<>();
        Random r = new Random();
        int x = 1;
        int y = 1;
        for (int i = 0; i < BAND_SIZE; i++) {
            switch (r.nextInt(1, 5)) {
                case 1 -> darkBand.add(new Peasant(darkBand, x++, y, 9));
                case 2 -> darkBand.add(new Spearman(darkBand, x++, y, 6));
                case 3 -> darkBand.add(new Crossbowman(darkBand, x++, y, 5));
                case 4 -> darkBand.add(new Warlock(darkBand, x++, y, 3));
            }
        }
        x = 1;
        y = 10;
        for (int i = 0; i < BAND_SIZE; i++) {
            switch (r.nextInt(1, 5)) {
                case 1 -> whiteBand.add(new Peasant(whiteBand, x++, y, 9));
                case 2 -> whiteBand.add(new Rogue(whiteBand, x++, y, 6));
                case 3 -> whiteBand.add(new Sniper(whiteBand, x++, y, 2));
                case 4 -> whiteBand.add(new Monk(whiteBand, x++, y, 3));
            }
        }
    }

    public static void makeTurn(ArrayList<BasicHero> darkBand, ArrayList<BasicHero> whiteBand) {
        for (BasicHero hero : darkBand) {
            if (hero.getName().equals("Crossbowman") && !hero.getStatus().equals("Dead")) hero.step(whiteBand);
        }
        for (BasicHero hero : whiteBand) {
            if (hero.getName().equals("Sniper") && !hero.getStatus().equals("Dead")) hero.step(darkBand);
        }
        for (BasicHero hero : darkBand) {
            if (hero.getName().equals("Spearman") && !hero.getStatus().equals("Dead")) hero.step(whiteBand);
        }
        for (BasicHero hero : whiteBand) {
            if (hero.getName().equals("Rogue") && !hero.getStatus().equals("Dead")) hero.step(darkBand);
        }
        for (BasicHero hero : darkBand) {
            if (hero.getName().equals("Warlock") && !hero.getStatus().equals("Dead")) hero.step(whiteBand);
        }
        for (BasicHero hero : whiteBand) {
            if (hero.getName().equals("Monk") && !hero.getStatus().equals("Dead")) hero.step(darkBand);
        }
        for (BasicHero hero : darkBand) {
            if (hero.getName().equals("Peasant") && !hero.getStatus().equals("Dead")) hero.step(whiteBand);
        }
        for (BasicHero hero : whiteBand) {
            if (hero.getName().equals("Peasant") && !hero.getStatus().equals("Dead")) hero.step(darkBand);
        }
    }
}