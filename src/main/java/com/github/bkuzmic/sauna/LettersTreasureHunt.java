package com.github.bkuzmic.sauna;

public class LettersTreasureHunt implements TreasureHunt {

    private StringBuffer path;
    private StringBuffer letters;

    public LettersTreasureHunt() {
        this.path = new StringBuffer();
        this.letters = new StringBuffer();
    }

    @Override
    public Prize findX(MapWithX map) {
        if (map.isEmpty()) {
            return new Prize("", "");
        }
        Spot start = map.find('@');
        path.append(start.character());
        Spot end = map.find('x');
        Spot current = start;
        while (!current.position().equals(end.position())) {
            current = map.move(current.position(), current.transition());
            path.append(current.character());
            if (Character.isLetter(current.character()) &&
                Character.isUpperCase(current.character())) {
                letters.append(current.character());
            }
        }
        return new Prize(letters.toString(), path.toString());
    }
}
