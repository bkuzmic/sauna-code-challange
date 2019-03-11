package com.github.bkuzmic.sauna;

public class CharGrid implements Grid {

    private char[][] grid;
    private int rows = 0;
    private int cols = 0;

    public CharGrid(String map) {
        createGrid(map);
    }

    private void createGrid(String map) {
        if (map.isEmpty()) {
            return;
        }
        String[] lines = map.split("\n");
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
                    if (lines[x].charAt(y) == ' ') {
                        this.grid[x][y] = '\0';
                    } else {
                        this.grid[x][y] = lines[x].charAt(y);
                    }
                } else {
                    this.grid[x][y] = '\0';
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
        StringBuffer buffer = new StringBuffer();
        for (int x = 0; x<this.rows; x++) {
            buffer.append(this.grid[x]);
            buffer.append("\n");
        }
        return buffer.toString();
    }
}
