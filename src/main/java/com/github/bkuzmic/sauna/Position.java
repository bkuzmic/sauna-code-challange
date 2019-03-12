package com.github.bkuzmic.sauna;

import java.util.Objects;

public class Position {

    private int x;
    private int y;
    private Direction current;
    private Direction from;

    public Position(int x, int y, Direction current, Direction from) {
        this.x = x;
        this.y = y;
        this.current = current;
        this.from = from;
    }

    public int getX() {
        return this.x;
    }

    public int getY() {
        return this.y;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Position position = (Position) o;
        return x == position.x &&
            y == position.y;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }
}
