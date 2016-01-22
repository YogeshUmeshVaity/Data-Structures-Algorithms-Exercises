package com.company;

import java.util.LinkedList;

/**
 * Created by try on 20/1/16.
 */
public class Knapsack {
    private int[] weights = {11, 8, 7, 6, 5};
    private LinkedList<Integer> knapsack = new LinkedList<>();

    public void fitItems(int targetWeight, int startingIndex) {
        knapsack.add(weights[startingIndex]);
        if(targetWeight == weights[startingIndex]) {
            return;
        } else if(targetWeight > weights[startingIndex] && startingIndex < weights.length) {
            fitItems(targetWeight - weights[startingIndex], startingIndex + 1);
        } else if(targetWeight < weights[startingIndex] && startingIndex < weights.length) {
            knapsack.removeLast();
            if(startingIndex == weights.length - 1) return;
            fitItems(targetWeight, startingIndex + 1);

        }


    }

    public void displayFittedItems() {
        System.out.println(knapsack);
    }
}
