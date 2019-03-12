package com.github.bkuzmic.sauna;

public interface XMap {

    boolean isEmpty();

    Spot find(char character);

    Spot move(Position position, Transition transition);
}
