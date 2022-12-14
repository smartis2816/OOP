import Characters.AbstractClasses.BasicHero;
import View.AnsiColors;
import View.Coordinates;

import java.util.Collections;

public class ConsoleView {
    public static int step = 0;
    private static final String top10 = formatDiv("a") + String.join("", Collections.nCopies(9, formatDiv("jb"))) + formatDiv("jc");
    private static final String mid10 = formatDiv("d") + String.join("", Collections.nCopies(9, formatDiv("-e"))) + formatDiv("-f");
    private static final String bottom10 = formatDiv("g") + String.join("", Collections.nCopies(9, formatDiv("jh"))) + formatDiv("ji");

    public static void view() {
        if (step++ == 0) System.out.println(AnsiColors.ANSI_RED + "First step" + AnsiColors.ANSI_RESET);
        else System.out.println(AnsiColors.ANSI_RED + "Step: " + step + AnsiColors.ANSI_RESET);
        System.out.print(BasicHero.getSpace(24));
        System.out.print(AnsiColors.ANSI_GREEN + printTopic() + AnsiColors.ANSI_RESET);
        System.out.println(AnsiColors.ANSI_BLUE + printTopic() + AnsiColors.ANSI_RESET);
        System.out.println(ConsoleView.top10);

        for (int i = 1; i <= Main.BAND_SIZE - 1; i++) {
            StringBuilder heroData = new StringBuilder("   ");
            for (int j = 1; j <= Main.BAND_SIZE; j++) {
                System.out.print(getChar(new Coordinates(i, j)));
                heroData.append(getHeroData(new Coordinates(i, j)));
            }
            System.out.print(formatDiv("k"));
            System.out.println(heroData);
            System.out.println(ConsoleView.mid10);
        }

        for (int j = 1; j <= Main.BAND_SIZE; j++) {
            System.out.print(getChar(new Coordinates(10, j)));
        }
        System.out.print(formatDiv("k"));
        System.out.println("   " + getHeroData(new Coordinates(10, 1)) + getHeroData(new Coordinates(10, 10)));
        System.out.println(ConsoleView.bottom10);
    }

    private static String getChar(Coordinates position) {
        String str = "| ";
        for (int i = 0; i < Main.BAND_SIZE; i++) {
            if (Main.darkBand.get(i).getPosition().isEqual(position)) {
                if (Main.darkBand.get(i).getStatus().equals("Dead")) {
                    str = "\u2551" + AnsiColors.ANSI_RED + Main.darkBand.get(i).getName().charAt(0) + AnsiColors.ANSI_RESET;
                } else {
                    str = "\u2551" + AnsiColors.ANSI_GREEN + Main.darkBand.get(i).getName().charAt(0) + AnsiColors.ANSI_RESET;
                }
            }
            if (Main.whiteBand.get(i).getPosition().isEqual(position)) {
                if (Main.whiteBand.get(i).getStatus().equals("Dead")) {
                    str = "\u2551" + AnsiColors.ANSI_RED + Main.whiteBand.get(i).getName().charAt(0) + AnsiColors.ANSI_RESET;
                } else {
                    str = "|" + AnsiColors.ANSI_BLUE + Main.whiteBand.get(i).getName().charAt(0) + AnsiColors.ANSI_RESET;
                }
            }
        }
        return str;
    }

    public static String printTopic() {
        return "Name         " +
                "Status      " +
                "Health      " +
                "Amount      ";
    }

    public static String getHeroData(Coordinates position) {
        String str = "";
        for (int i = 0; i < Main.BAND_SIZE; i++) {
            if (Main.darkBand.get(i).getPosition().isEqual(position)) {
                str = Main.darkBand.get(i).getParameters();
            } else if (Main.whiteBand.get(i).getPosition().isEqual(position)) {
                str = Main.whiteBand.get(i).getParameters();
            }
        }
        return str;
    }

    public static String formatDiv(String str) {
        return str.replace('a', '\u2554')
                .replace('b', '\u2564')
                .replace('c', '\u2557')
                .replace('d', '\u255f')
                .replace('e', '\u253c')
                .replace('f', '\u2562')
                .replace('g', '\u255a')
                .replace('h', '\u2567')
                .replace('i', '\u255d')
                .replace('j', '\u2550')
                .replace('k', '\u2551')
                .replace('-', '\u2500')
                .replace("s", "...")
                .replace("o", "___");
    }
}

