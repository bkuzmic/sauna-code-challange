package com.github.bkuzmic.sauna;

public class CharGrid implements Grid {

    private final static String LINE_DELIMITER = "\n";
    private final static char SPACE = ' ';
    private final static char BLANK = '\0';

    private String cachedMap;
    private char[][] grid;
    private int rows = 0;
    private int cols = 0;

    public CharGrid(String map) {
        this.cachedMap = map;
        createGrid(map);
    }

    private void createGrid(String map) {
        if (map.isEmpty()) {
            return;
        }
        String[] lines = map.split(LINE_DELIMITER);
        for (String line : lines) {
            int len = line.length();
            if (len > this.cols) {
                this.cols = len;
            }
            this.rows++;
        }
        this.grid = new char[this.rows][this.cols];
        for (int x = 0; x < this.rows; x++) {
            int len = lines[x].length();
            for (int y = 0; y < this.cols; y++) {
                if (y < len) {
                    if (lines[x].charAt(y) == SPACE) {
                        this.grid[x][y] = BLANK;
                    } else {
                        this.grid[x][y] = lines[x].charAt(y);
                    }
                } else {
                    this.grid[x][y] = BLANK;
                }
            }
        }
    }

    @Override
    public char pos(int x, int y) {
        return this.grid[x][y];
    }

    @Override
    public int totalRows() {
        return this.rows;
    }

    @Override
    public int totalCols() {
        return this.cols;
    }

    @Override
    public String print() {
        return this.cachedMap;
    }
}
