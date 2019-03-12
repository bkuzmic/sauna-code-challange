package com.github.bkuzmic.sauna;

import org.hamcrest.MatcherAssert;
import org.hamcrest.core.IsEqual;
import org.junit.Before;
import org.junit.Test;

public class LettersTreasureHuntTest {

    private TreasureHunt hunt;

    @Before
    public void setUp() {
        hunt = new LettersTreasureHunt();
    }

    @Test
    public void emptyMap() {
        MapWithX map = new TreasureMap(new CharGrid(""));
        Prize prize = hunt.findX(map);
        MatcherAssert.assertThat(
            "Letters are not empty",
            prize.letters(),
            new IsEqual<>("")
        );
        MatcherAssert.assertThat(
            "Path is not empty",
            prize.path(),
            new IsEqual<>("")
        );
    }

    @Test
    public void simpleMap() {
        String map = "  @---A---+\n" +
                     "          |\n" +
                     "  x-B-+   C\n" +
                     "      |   |\n" +
                     "      +---+\n";

        Grid grid = new CharGrid(map);
        Prize prize = hunt.findX(new TreasureMap(grid));
        MatcherAssert.assertThat(
            "Letters don't match",
            prize.letters(),
            new IsEqual<>("ACB")
        );
        MatcherAssert.assertThat(
            "Path doesn't match",
            prize.path(),
            new IsEqual<>("@---A---+|C|+---+|+-B-x")
        );
    }

    @Test
    public void loopingMap() {
        String map = "  @\n" +
                     "  | C----+\n" +
                     "  A |    |\n" +
                     "  +---B--+\n" +
                     "    |      x\n" +
                     "    |      |\n" +
                     "    +---D--+\n";
        Grid grid = new CharGrid(map);
        Prize prize = hunt.findX(new TreasureMap(grid));
        MatcherAssert.assertThat(
            "Letters don't match",
            prize.letters(),
            new IsEqual<>("ABCD")
        );
        MatcherAssert.assertThat(
            "Path doesn't match",
            prize.path(),
            new IsEqual<>("@|A+---B--+|+----C|-||+---D--+|x")
        );
    }

    @Test
    public void loopingMapWithRepeatingLetters() {
        String map = "  @---+\n" +
                     "      B\n" +
                     "K-----|--A\n" +
                     "|     |  |\n" +
                     "|  +--E  |\n" +
                     "|  |     |\n" +
                     "+--E--Ex C\n" +
                     "   |     |\n" +
                     "   +--F--+\n";

        Grid grid = new CharGrid(map);
        Prize prize = hunt.findX(new TreasureMap(grid));
//        MatcherAssert.assertThat(
//            "Letters don't match",
//            prize.letters(),
//            new IsEqual<>("BEEFCAKE")
//        );
        MatcherAssert.assertThat(
            "Path doesn't match",
            prize.path(),
            new IsEqual<>("@---+B||E--+|E|+--F--+|C|||A--|-----K|||+--E--Ex")
        );
    }

}
