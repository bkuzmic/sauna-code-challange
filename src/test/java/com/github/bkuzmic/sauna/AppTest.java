package com.github.bkuzmic.sauna;

import org.junit.Test;

public class AppTest {

    @Test
    public void runsOk() {
        App app = new App(this.getClass().getResource("/map1.txt").getPath());
    }

}
