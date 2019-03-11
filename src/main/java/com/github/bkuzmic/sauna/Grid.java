package com.github.bkuzmic.sauna;

public interface Grid {

    char pos(int x, int y);

    int totalRows();
    int totalCols();

    String print();

}
