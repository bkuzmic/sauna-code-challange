package com.github.bkuzmic.sauna;

public interface Map {

    boolean isEmpty();

    Position findCharacter(char character);

    Position move(Position to);
}
