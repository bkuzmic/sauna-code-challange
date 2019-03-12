package com.github.bkuzmic.sauna;

import com.github.bkuzmic.sauna.exceptions.CharacterNotFoundException;
import java.util.HashMap;
import java.util.Map;

public class TreasureMap implements XMap {

    private final static char BLANK = '\0';

    private final Grid grid;
    private Map<Direction, Direction> next;
    private Map<Direction, Direction> impossibleDirections;
    private Map<Direction, Position> movements;

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
        this.movements.put(Direction.RIGHT, new Position(0, 1));
        this.movements.put(Direction.DOWN, new Position(1, 0));
        this.movements.put(Direction.LEFT, new Position(0, -1));
        this.movements.put(Direction.UP, new Position(-1, 0));
    }

    @Override
    public boolean isEmpty() {
        return this.grid.totalCols() == 0 && this.grid.totalRows() == 0;
    }

    @Override
    public Spot find(char character) {
        for (int x = 0; x < this.grid.totalRows(); x++) {
            for (int y = 0; y < this.grid.totalCols(); y++) {
                if (this.grid.pos(x, y) == character) {
                    return new Spot(
                        new Position(x, y),
                        new Transition(
                            Direction.RIGHT,
                            Direction.RIGHT
                        ),
                        true,
                        character
                    );
                }
            }
        }
        throw new CharacterNotFoundException(
            String.format("Error! Character %s is missing", character)
        );
    }

    @Override
    public Spot move(Position position, Transition transition) {
        if (transition.from().equals(
            impossibleDirections.get(transition.current())
        )) {
            return move(
                position,
                new Transition(
                    next.get(transition.current()),
                    transition.from()
                )
            );
        }
        Spot spot = makeMove(position, transition);
        if (!spot.isMovable()) {
            return move(
                position,
                new Transition(
                    next.get(transition.current()),
                    transition.from()
                )
            );
        }
        return spot;
    }


    private Spot makeMove(Position position, Transition transition) {
        int x = position.getX() + this.movements.get(transition.current()).getX();
        int y = position.getY() + this.movements.get(transition.current()).getY();
        char character = BLANK;
        if (x>=0 && x < this.grid.totalRows() &&
            y>=0 && y < this.grid.totalCols()) {
            character = this.grid.pos(x, y);
        }
        return new Spot(
            new Position(x, y),
            new Transition(
                transition.current(), transition.current()
            ),
            character != BLANK,
            character
        );
    }


}
