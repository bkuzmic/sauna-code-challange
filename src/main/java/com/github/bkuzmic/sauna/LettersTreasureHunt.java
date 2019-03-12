package com.github.bkuzmic.sauna;

public class LettersTreasureHunt implements TreasureHunt {

    private Prize prize;

    public LettersTreasureHunt() {
        this.prize = new Prize();
    }

    @Override
    public Prize findX(XMap map) {
        if (map.isEmpty()) {
            return this.prize;
        }
        Spot start = map.find('@');
        this.prize.path(start.character());
        Spot end = map.find('x');
        Spot current = start;
        while (!current.position().equals(end.position())) {
            current = map.move(current.position(), current.transition());
            this.prize.path(current.character());
            this.prize.letter(current.character(), current.position());
        }
        return this.prize;
    }
}
