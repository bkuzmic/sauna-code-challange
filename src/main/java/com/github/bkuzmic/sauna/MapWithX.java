package com.github.bkuzmic.sauna;

public interface MapWithX {

    boolean isEmpty();

    Spot findCharacter(char character);

    Spot move(Position to);
}
