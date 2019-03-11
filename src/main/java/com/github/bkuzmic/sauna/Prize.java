package com.github.bkuzmic.sauna;

public class Prize {

    private final String letters;
    private final String path;

    public Prize(String letters, String path) {
        this.letters = letters;
        this.path = path;
    }

    public String letters() {
        return this.letters;
    }

    public String path() {
        return this.path;
    }

}
