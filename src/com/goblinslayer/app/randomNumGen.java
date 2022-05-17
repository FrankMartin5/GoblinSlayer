package com.goblinslayer.app;
import java.util.Random;

public class randomNumGen {

    public int returnRandom(int x) {
        Random random = new Random();
        int y = random.nextInt(x);
        return y;
    }

}
