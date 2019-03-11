package com.github.bkuzmic.sauna;

import org.hamcrest.MatcherAssert;
import org.hamcrest.core.IsEqual;
import org.junit.Before;
import org.junit.Test;

public class WorldMapTest {

    private Map worldMap;

    @Before
    public void setUp() {
        String map = "  @---A---+\n" +
                     "          |\n" +
                     "  x-B-+   C\n" +
                     "      |   |\n" +
                     "      +---+\n";

        Grid grid = new CharGrid(map);
        worldMap = new WorldMap(grid);
    }

    @Test
    public void moveToRight() {
        Position position = worldMap.move(new Position(0, 3));

        MatcherAssert.assertThat(position.getX(), new IsEqual<>(0));
        MatcherAssert.assertThat(position.getY(), new IsEqual<>(4));
    }

    @Test
    public void findStartCharacter() {
        Position start = worldMap.findCharacter('@');

        MatcherAssert.assertThat(start.getX(), new IsEqual<>(0));
        MatcherAssert.assertThat(start.getY(), new IsEqual<>(2));
    }

}
