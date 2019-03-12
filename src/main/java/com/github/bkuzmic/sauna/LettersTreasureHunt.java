package com.github.bkuzmic.sauna;

public class LettersTreasureHunt implements TreasureHunt {

    private StringBuffer path;
    private StringBuffer letters;

    public LettersTreasureHunt() {
        this.path = new StringBuffer();
        this.letters = new StringBuffer();
    }

    @Override
    public Prize x(MapWithX map) {
        if (map.isEmpty()) {
            return new Prize("", "");
        }
        Spot start = map.findCharacter('@');
        Spot current = new Spot(
            new Position(start.position().getX(), start.position().getY(), Direction.RIGHT, Direction.RIGHT),
            start.isMovable(),
            start.character()
        );
        Spot end = map.findCharacter('x');
        path.append(start.character());
        while (!current.position().equals(end.position())) {
            current = map.move(current.position());
            path.append(current.character());
            if (Character.isLetter(current.character()) &&
                Character.isUpperCase(current.character())) {
                letters.append(current.character());
            }
        }
        return new Prize(letters.toString(), path.toString());
    }
}
