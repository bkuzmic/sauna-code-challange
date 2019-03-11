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
        Prize prize = hunt.x("");
        MatcherAssert.assertThat(
            "Letters are not empty",
            "",
            new IsEqual<>(prize.letters())
        );
        MatcherAssert.assertThat(
            "Path is not empty",
            "",
            new IsEqual<>(prize.path())
        );
    }

    @Test
    public void simpleMap() {
        String map = "  @---A---+\n" +
                     "          |\n" +
                     "  x-B-+   C\n" +
                     "      |   |\n" +
                     "      +---+s\n";
        Prize prize = hunt.x(map);
        MatcherAssert.assertThat(
            "Letters don't match",
            prize.letters(),
            new IsEqual<>("ACB"));
        MatcherAssert.assertThat(
            "Path doesn't match",
            prize.path(),
            new IsEqual<>("@---A---+|C|+---+|+-B-x")
        );
    }

}
