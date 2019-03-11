package com.github.bkuzmic.sauna;

public class LettersTreasureHunt implements TreasureHunt {

    private StringBuffer path;
    private StringBuffer letters;

    public LettersTreasureHunt() {
        this.path = new StringBuffer();
        this.letters = new StringBuffer();
    }

    @Override
    public Prize x(Map map) {
        if (map.isEmpty()) {
            return new Prize("", "");
        }
        Position start = map.findCharacter('@');
        Position end = map.findCharacter('x');
        return new Prize(letters.toString(), path.toString());
    }
}
