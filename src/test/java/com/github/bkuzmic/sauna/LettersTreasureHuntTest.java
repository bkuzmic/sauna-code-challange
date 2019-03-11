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
        Map map = new WorldMap(new CharGrid(""));
        Prize prize = hunt.x(map);
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

}
