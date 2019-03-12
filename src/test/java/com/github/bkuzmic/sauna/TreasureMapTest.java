package com.github.bkuzmic.sauna;

import org.hamcrest.MatcherAssert;
import org.hamcrest.core.IsEqual;
import org.junit.Before;
import org.junit.Test;

public class TreasureMapTest {

    private XMap treasureMap;

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
        Spot spot = treasureMap.move(
            new Position(0, 3),
            new Transition(Direction.RIGHT, Direction.RIGHT)
        );

        MatcherAssert.assertThat(
            spot.position(),
            new IsEqual<>(new Position(0, 4))
        );
    }

    @Test
    public void findStartCharacter() {
        Spot start = treasureMap.find('@');

        MatcherAssert.assertThat(
            start.position(),
            new IsEqual<>(new Position(0, 2))
        );
    }

}
