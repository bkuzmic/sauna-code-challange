package com.github.bkuzmic.sauna;

public class Transition {

    private Direction current;
    private Direction from;

    public Transition(Direction current, Direction from) {
        this.current = current;
        this.from = from;
    }

    public Direction getCurrent () {
        return this.current;
    }

    public Direction getFrom() {
        return this.from;
    }

    public void setFrom(Direction from) {
        this.from = from;
    }

}
