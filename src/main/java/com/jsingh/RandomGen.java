package com.jsingh;

import java.util.ArrayList;
import java.util.List;

public class RandomGen {
    // Values that may be returned by nextNum() private
     private int[] randomNums;
    // Probability of the occurence of randomNums private
     private float[] probabilities;
     private RandomFloat randomFloat;

    public RandomGen(int[] randomNums, float[] probabilities) {
        this.randomNums = randomNums;
        this.probabilities = probabilities;
        this.randomFloat = new RandomFloatImpl();
        conditionsCheck(randomNums,probabilities,randomFloat);
    }

    private void conditionsCheck(int[] randomNums,float[] probabilities, RandomFloat randomFloat){
        float sumOfProbabilities = 0;
        for(float probability : probabilities){ sumOfProbabilities += probability; }
        if(randomNums.length != probabilities.length){ throw new IllegalArgumentException("there must be a probability assigned for each number in randomNums"); }
        if(randomNums == null || probabilities == null || randomFloat == null){ throw new IllegalArgumentException("randomNums, probabilities and random generator must all have an entry "); }
        if(sumOfProbabilities != 1){ throw new IllegalArgumentException("Total probabilities must be 1"); }
        }

    /**
     Returns one of the randomNums. When this method is called multiple times over a long period, it should return the numbers roughly with the initialized probabilities.
     */
    public int nextNum() {
        float rand = randomFloat.getRandomFloat();
        int len = probabilities.length;
        List<Float> cumulativeProbs = new ArrayList<>();
        float a = 0;
        for(int i=0;i < len;i++)
        {
            a += probabilities[i];
            cumulativeProbs.add(a);
        }
        int result = 0;
        if (rand < cumulativeProbs.get(0)) {result = randomNums[0];}
        if (cumulativeProbs.get(0)<rand && rand < cumulativeProbs.get(1)) {result = randomNums[1];}
        if (cumulativeProbs.get(1)<rand && rand < cumulativeProbs.get(2)) {result = randomNums[2];}
        if (cumulativeProbs.get(2)<rand && rand < cumulativeProbs.get(3)) {result = randomNums[3];}
        if(rand>cumulativeProbs.get(4)) {result = randomNums[4];}

        System.out.println(result);
        return result;
    }

    public static void main(String[] args) {
//        int[] numbers = {-1, 0, 1, 2, 3};
//        float[] probabilities = {0.01f, 0.3f, 0.58f, 0.1f, 0.01f};
//        RandomGen randomGen = new RandomGen(numbers, probabilities);
//        ArrayList<Integer> generatedNumbers = new ArrayList<>();
//        for(int i=0; i < 100; i++){
//            randomGen.nextNum();
//        }
    }
}