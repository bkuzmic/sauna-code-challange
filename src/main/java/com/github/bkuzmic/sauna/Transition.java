package com.github.bkuzmic.sauna;

public class Transition {

    private final Direction current;
    private final Direction from;

    public Transition(Direction current, Direction from) {
        this.current = current;
        this.from = from;
    }

    public Direction current() {
        return this.current;
    }

    public Direction from() {
        return this.from;
    }

}
