package com.jsingh;

import java.util.Random;

public class RandomFloatImpl implements RandomFloat {

    @Override
    public float getRandomFloat() {
        return new Random().nextFloat();
    }
}
