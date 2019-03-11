package com.github.bkuzmic.sauna;

import com.github.bkuzmic.sauna.exceptions.CharacterNotFoundException;

public class WorldMap implements Map {

    private final Grid grid;

    public WorldMap(Grid grid) {
        this.grid = grid;
    }

    @Override
    public boolean isEmpty() {
        return this.grid.totalCols() == 0 && this.grid.totalRows() == 0;
    }

    @Override
    public Position findCharacter(char character) {
        for (int x = 0; x < this.grid.totalRows(); x++) {
            for (int y = 0; y < this.grid.totalCols(); y++) {
                if (this.grid.pos(x, y) == character) {
                    return new Position(x, y);
                }
            }
        }
        throw new CharacterNotFoundException(
            String.format("Error! Character %s is missing", character)
        );
    }

    @Override
    public Position move(Position to) {
        Spot spot = canMove(to.getX(), to.getY() + 1);
        if (spot.isMovable()) {
            return new Position(spot.position().getX(), spot.position().getY());
        }
        return new Position(0, 0);
    }


    private Spot canMove(int x, int y) {
        if (this.grid.pos(x, y) == '\0') {
            return new Spot(new Position(x, y), false, '\0');
        }
        return new Spot(new Position(x, y), true, this.grid.pos(x, y));
    }


}
