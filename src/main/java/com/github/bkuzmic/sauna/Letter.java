package com.github.bkuzmic.sauna;

import java.util.Objects;

public class Letter {

    private char character;
    private Position position;

    public Letter(char character, Position position) {
        this.character = character;
        this.position = position;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Letter letter = (Letter) o;
        return this.character == letter.character &&
            Objects.equals(this.position, letter.position);
    }

    @Override
    public int hashCode() {
        return Objects.hash(character, position);
    }

    @Override
    public String toString() {
        return Character.toString(this.character);
    }
}
