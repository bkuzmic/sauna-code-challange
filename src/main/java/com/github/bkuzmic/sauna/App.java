package com.github.bkuzmic.sauna;

import java.io.File;
import java.io.IOException;
import org.cactoos.text.TextOf;

public class App {

    public static void main(String[] args) {
        System.out.println("--- Sauna Code Challenge ---");
        System.out.println("- a.k.a. Treasure hunt :-) -\n");
        if (args == null || args.length <= 0) {
            System.err.println(
                String.join(
                    " ",
                    "Error, missing map file. Please provide",
                    "full path to file, like, for example: /home/user/map.txt"
                )
            );
            System.exit(2);
        }
        new App(args[0]);
    }

    public App(String mapFile) {
        try {
            Grid grid = new CharGrid(readMapFromFile(mapFile));
            System.out.println("--- Printing map ---\n");
            System.out.println(grid.print());
            System.out.print("\n");
            TreasureHunt hunt = new LettersTreasureHunt();
            Prize prize = hunt.findX(new TreasureMap(grid));
            printResult(prize);
        } catch (IOException error) {
            System.err.println(
                String.format(
                    "Error while reading file %s: %s",
                    mapFile,
                    error.getMessage()
                )
            );
        }
    }

    private String readMapFromFile(String mapFile) throws IOException {
        return new TextOf(
            new File(mapFile)
        ).asString();
    }

    private void printResult(Prize prize) {
        System.out.println("--- Result ---");
        System.out.println(
            String.format("Found letters: %s", prize.printLetters())
        );
        System.out.println(
            String.format("With path: %s", prize.printPath())
        );
    }

}
