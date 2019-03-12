package com.github.bkuzmic.sauna;

import com.github.bkuzmic.sauna.exceptions.CharacterNotFoundException;
import java.util.HashMap;
import java.util.Map;

public class TreasureMap implements MapWithX {

    private final Grid grid;
    private Map<Direction, Direction> next;
    private Map<Direction, Direction> impossibleDirections;
    private Map<Direction, Integer[]> movements;

    public TreasureMap(Grid grid) {
        this.grid = grid;
        this.next = new HashMap<>();
        this.next.put(Direction.RIGHT, Direction.DOWN);
        this.next.put(Direction.DOWN, Direction.LEFT);
        this.next.put(Direction.LEFT, Direction.UP);
        this.next.put(Direction.UP, Direction.RIGHT);
        this.impossibleDirections = new HashMap<>();
        this.impossibleDirections.put(Direction.LEFT, Direction.RIGHT);
        this.impossibleDirections.put(Direction.RIGHT, Direction.LEFT);
        this.impossibleDirections.put(Direction.DOWN, Direction.UP);
        this.impossibleDirections.put(Direction.UP, Direction.DOWN);
        this.movements = new HashMap<>();
        this.movements.put(Direction.RIGHT, new Integer[]{0, 1});
        this.movements.put(Direction.DOWN, new Integer[]{1, 0});
        this.movements.put(Direction.LEFT, new Integer[]{0, -1});
        this.movements.put(Direction.UP, new Integer[]{-1, 0});
    }

    @Override
    public boolean isEmpty() {
        return this.grid.totalCols() == 0 && this.grid.totalRows() == 0;
    }

    @Override
    public Spot findCharacter(char character) {
        for (int x = 0; x < this.grid.totalRows(); x++) {
            for (int y = 0; y < this.grid.totalCols(); y++) {
                if (this.grid.pos(x, y) == character) {
                    return new Spot(
                        new Position(x, y, Direction.RIGHT, Direction.RIGHT), true, character
                    );
                }
            }
        }
        throw new CharacterNotFoundException(
            String.format("Error! Character %s is missing", character)
        );
    }

    @Override
    public Spot move(Position to) {
        if (to.getFrom().equals(impossibleDirections.get(to.getCurrent()))) {
            return move(
                new Position(
                    to.getX(),
                    to.getY(),
                    next.get(to.getCurrent()),
                    to.getFrom()
                )
            );
        }
        Spot spot = canMove(to);
        if (!spot.isMovable()) {
            return move(
                new Position(
                    to.getX(),
                    to.getY(),
                    next.get(to.getCurrent()),
                    to.getFrom()
                )
            );
        }
        spot.position().setFrom(to.getCurrent());
        return spot;
    }


    private Spot canMove(Position to) {
        int x = to.getX() + this.movements.get(to.getCurrent())[0];
        int y = to.getY() + this.movements.get(to.getCurrent())[1];
        if (x < this.grid.totalRows() && y < this.grid.totalCols()) {
            if (this.grid.pos(x, y) == '\0') {
                return new Spot(
                    new Position(x, y, to.getCurrent(), to.getFrom()), false, '\0'
                );
            } else {
                return new Spot(
                    new Position(x, y, to.getCurrent(), to.getFrom()), true, this.grid.pos(x, y)
                );
            }
        } else {
            return new Spot(
                new Position(x, y, to.getCurrent(), to.getFrom()), false, '\0'
            );
        }
    }


}
