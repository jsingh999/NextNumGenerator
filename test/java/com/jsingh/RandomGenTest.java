package com.jsingh;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.junit.Assert.assertTrue;

public class RandomGenTest {

    @Test
    public void nextNum() {
        int[] numbers = {-1, 0, 1, 2, 3};
        float[] probabilities = {0.01f, 0.3f, 0.58f, 0.1f, 0.01f};
        RandomGen randomGen = new RandomGen(numbers, probabilities);
        List<Integer> generatedNumbers = new ArrayList<>();
        for(int i=0; i < 100; i++){
            generatedNumbers.add(randomGen.nextNum());
        }
        int a = Collections.frequency(generatedNumbers, -1);
        int b = Collections.frequency(generatedNumbers, 0);
        int c = Collections.frequency(generatedNumbers, 1);
        int d = Collections.frequency(generatedNumbers, 2);
        int e = Collections.frequency(generatedNumbers, 3);

        assertTrue(0<=a && a<=2);
        assertTrue(25<b && b<35);
        assertTrue(50<c && c<66);
        assertTrue(7<d && d<13);
        assertTrue(0<=e && e<=2);

    }
}