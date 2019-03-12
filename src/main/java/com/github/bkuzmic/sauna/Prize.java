package com.github.bkuzmic.sauna;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Prize {

    private StringBuffer path;
    private List<Letter> letters;

    public Prize() {
        this.path = new StringBuffer();
        this.letters = new ArrayList<>();
    }

    public void letter(char character, Position position) {
        if (Character.isLetter(character) && Character.isUpperCase(character)) {
            Letter letter = new Letter(character, position);
            if (this.letters.lastIndexOf(letter) == -1) {
                this.letters.add(letter);
            }
        }
    }

    public void path(char character) {
        this.path.append(character);
    }

    public String printPath() {
        return this.path.toString();
    }

    public String printLetters() {
        return this.letters.stream().map(Letter::toString).collect(
            Collectors.joining("")
        );
    }

}
