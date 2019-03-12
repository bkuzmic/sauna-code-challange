package com.github.bkuzmic.sauna;

import org.hamcrest.MatcherAssert;
import org.hamcrest.core.IsEqual;
import org.junit.Before;
import org.junit.Test;

public class TreasureMapTest {

    private MapWithX treasureMap;

    @Before
    public void setUp() {
        String map = "  @---A---+\n" +
                     "          |\n" +
                     "  x-B-+   C\n" +
                     "      |   |\n" +
                     "      +---+\n";

        Grid grid = new CharGrid(map);
        treasureMap = new TreasureMap(grid);
    }

    @Test
    public void moveToRight() {
        Spot spot = treasureMap.move(new Position(0, 3, Direction.RIGHT, Direction.RIGHT));

        MatcherAssert.assertThat(spot.position().getX(), new IsEqual<>(0));
        MatcherAssert.assertThat(spot.position().getY(), new IsEqual<>(4));
    }

    @Test
    public void findStartCharacter() {
        Spot start = treasureMap.findCharacter('@');

        MatcherAssert.assertThat(start.position().getX(), new IsEqual<>(0));
        MatcherAssert.assertThat(start.position().getY(), new IsEqual<>(2));
    }

}
