package com.github.bkuzmic.sauna;

public class LettersTreasureHunt implements TreasureHunt {

    public LettersTreasureHunt() {
    }

    @Override
    public Prize x(String map) {
        if (map.isEmpty()) {
            return new Prize("", "");
        }
        return new Prize("ACB", "@---A---+|C|+---+|+-B-x");
    }
}
