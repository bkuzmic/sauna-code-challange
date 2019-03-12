package com.github.bkuzmic.sauna;

public class Spot {

    private Position position;
    private Transition transition;
    private boolean movable;
    private char character;

    public Spot(Position position, Transition transition, boolean movable, char character) {
        this.position = position;
        this.transition = transition;
        this.movable = movable;
        this.character = character;
    }

    public boolean isMovable() {
        return this.movable;
    }

    public char character() {
        return this.character;
    }

    public Position position() {
        return this.position;
    }

    public Transition transition() {
        return this.transition;
    }
}
